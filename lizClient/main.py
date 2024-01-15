import grpc
import tensorflow as tf
import numpy as np
import io
from concurrent import futures
import random

import proto_pb2
import proto_pb2_grpc


class ServiceServicer(proto_pb2_grpc.ServiceServicer):
    def phrase (self, request, context) :
        f = io.open("trainText.txt", mode="r", encoding="utf-8")
        text = f.read()
        chars = sorted(list(set(text)))
        char_to_int = {ch: i for i, ch in enumerate(chars)}
        int_to_char = {i: ch for i, ch in enumerate(chars)}

        model = tf.keras.models.load_model('trainedModelLiz.h5')
        # Initialize the generated text
        pos_start=["рус ","богатыри ","битва ",'глупые ',"ящеры ","хитрость ","Оружие ","воин ","хлюпак ","раб ","Байкал ","я ","они ","слабый ","ничтожный ","Хоботки ","русские" ,"оружие ","слабые "]
        generated_text = random.choice(pos_start)

        # Encode the seed as integers
        encoded_seed = [char_to_int[ch] for ch in random.choice(pos_start)]

        # Pad the seed
        padded_seed = tf.keras.preprocessing.sequence.pad_sequences([encoded_seed], maxlen=50, padding='post')

        # Generate characters
        for i in range(50):
            # Get the next character probabilities
            probs = model.predict(padded_seed)[0]

            # Get the index of the character with the highest probability
            index = np.argmax(probs)

            # Add the character to the generated text
            generated_text += int_to_char[index]

            # Update the padded seed with the latest character
            padded_seed = np.append(padded_seed[0][1:], index)
            padded_seed = tf.keras.preprocessing.sequence.pad_sequences([padded_seed], maxlen=50, padding='post')

        res = proto_pb2.Response()
        res.phrase = generated_text
        print(res)
        return res
def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    proto_pb2_grpc.add_ServiceServicer_to_server(ServiceServicer(),server)
    server.add_insecure_port("localhost:50051")
    server.start()
    server.wait_for_termination()


if __name__ == "__main__":
    serve()
