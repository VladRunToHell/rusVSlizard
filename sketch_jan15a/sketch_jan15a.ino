#define G_PIN A4

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(A4, INPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(analogRead(G_PIN) > 1000)
  Serial.write("left");
  if(analogRead(G_PIN) < 100)
  Serial.write("right");
}
