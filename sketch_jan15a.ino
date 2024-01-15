/*пин №13 связан со встроенным светодиодом на платах Uno,
 * Mega, Nano, Leonardo, Mini и др.
 */
  #define G_PIN A4

void setup() {
  //открытие Serial-порта со скоростью 9600 бод/c
  Serial.begin(9600);


  //настройка пина со светодиодом в режим выхода
  pinMode(G_PIN, INPUT);
}

void loop() {
if (analogRead(G_PIN) > 1000) {
    Serial.write("left");
}
if (analogRead(G_PIN) < 100)
    Serial.write("right");
}