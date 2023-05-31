
long duration;

float distance, remplissage=0,y=0, MAX=0,TDR=0;// TDR taux de remplissage

int Trigpin 9, Echopin=10;

void setup() (

Serial.begin(9600); // begin the serial monitor at 9600 baud

pinMode(5, OUTPUT);// Trigpin

pinMode(10, INPUT);// Echopin while (millis() <4000)

digitalWrite(5, LOW);// set Trigpin low

delayMicroseconds(2);//delay

digitalWrite(5, HIGH); //set Trigpin high delayMicroseconds (10);// delay

digitalWrite(9, LOW); //set Trigpin low

duration pulseIn(10, HIGH); // set Echopin high to set time to variable distance duration 0.034/2; // covert time into distance

remplissage distance;

MAXX (MAX, remplissage } // calculte the UX value

Serial.print("volume MAX= ");

Serial.println(MAX); // print MAX

}

void loop(){

digitalWrite(9, LOW);

delayMicroseconds(2);

digitalWrite(9, HIGH);

delayMicroseconds (10);

digitalWrite(9, LOW);

duration pulse In (10, HIGH)

;

distance-duration 0.034/2;

remplissage-distance;

y= remplissage 100/MAX; // Calculates the percentage of MAX

TDR-100-y;

TDR constrain (TDR, 0, 100); // Inventory value between 0..100

Serial.print("volume de vide: ");

Serial.print(distance);

Serial.print("cm");

Serial.print("\t pourcentage de remplissage: "); Serial.print(TDR); // print TDR

Serial.println(" ");

delay(2000);

}
