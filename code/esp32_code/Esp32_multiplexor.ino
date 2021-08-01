#include <WiFi.h>
#include <FirebaseESP32.h>
//Provide the token generation process info.
#include "addons/TokenHelper.h"
//Provide the RTDB payload printing info and other helper functions.
#include "addons/RTDBHelper.h"
#include <ShiftIn.h>
#include <LiquidCrystal_I2C.h>
LiquidCrystal_I2C lcd = LiquidCrystal_I2C(0x3F, 16, 2);

#define DEVICE_UID "1X"

#define WIFI_SSID "TeleCentro-fa9a"
#define WIFI_PASSWORD "UDNYYJMF2NHZ"

// Your Firebase Project Web API Key
#define API_KEY "AIzaSyBn91QeWRTFmObDHwux17QOOvOhl9HvA0E"
// Your Firebase Realtime database URL
#define DATABASE_URL "https://carros-db-default-rtdb.firebaseio.com"

FirebaseData fbdo;
// Firebase Authentication Object
FirebaseAuth auth;
// Firebase configuration Object
FirebaseConfig config;
// Firebase database path
String databasePath = "";
// Firebase Unique Identifier
String fuid = "";
// Stores the elapsed time from device start up
unsigned long elapsedMillis = 0;
// The frequency of sensor updates to firebase, set to 10seconds
unsigned long update_interval = 10;
// Dummy counter to test initial firebase updates
int count = 0;
// Store device authentication status
bool isAuthenticated = false;
int datos[30];

ShiftIn<4> shift;
void setup() {
  lcd.begin(16, 2);
  lcd.init();
  lcd.backlight();
  lcd.setCursor(0, 0);
  // put your setup code here, to run once:
  // Initialise serial communication for local diagnostics
  Serial.begin(9600);
  // Initialise Connection with location WiFi
  wifi_Init();
  // Initialise firebase configuration and signup anonymously
  firebase_init();
  shift.begin(5, 2, 15, 4);

}

void loop() {
  // put your main code here, to run repeatedly:

  if (shift.update())
  { //   read in all values. returns true if any button has changed
    database_test();
  }
  delay(50);
}


void wifi_Init() {
  WiFi.begin(WIFI_SSID, WIFI_PASSWORD);
  Serial.print("Connecting to Wi-Fi");
  while (WiFi.status() != WL_CONNECTED) {
    Serial.print(".");
    delay(300);
  }
  Serial.println();
  Serial.print("Connected with IP: ");
  Serial.println(WiFi.localIP());
  Serial.println();
}


void firebase_init() {
  // configure firebase API Key
  config.api_key = API_KEY;
  // configure firebase realtime database url
  config.database_url = DATABASE_URL;
  // Enable WiFi reconnection
  Firebase.reconnectWiFi(true);
  Serial.println("------------------------------------");
  Serial.println("Sign up new user...");
  // Sign in to firebase Anonymously
  if (Firebase.signUp(&config, &auth, "", ""))
  {
    Serial.println("Success");
    isAuthenticated = true;
    // Set the database path where updates will be loaded for this device
    fuid = auth.token.uid.c_str();
  }
  else
  {
    Serial.printf("Failed, %s\n", config.signer.signupError.message.c_str());
    isAuthenticated = false;
  }
  // Assign the callback function for the long running token generation task, see addons/TokenHelper.h
  config.token_status_callback = tokenStatusCallback;
  // Initialise the firebase library
  Firebase.begin(&config, &auth);
}

void database_test() {
  // Check that 10 seconds has elapsed before, device is authenticated and the firebase service is ready.
  if (isAuthenticated && Firebase.ready())
  {

    /*Serial.println("------------------------------------");
      Serial.println("Set int test...");*/
    // Specify the key value for our data and append it to our path
    FirebaseJson json;
    lcd.setCursor(0, 0);
    for (int i = 0; i < shift.getDataWidth() - 2; i++)
    {
      datos[i] = !shift.state(i);
      lcd.print(datos[i]);
      json.set((String)i, !shift.state(i));
      Serial.print(!shift.state(i));
      if(i == 15){
        lcd.setCursor(0, 1);
      }
      
    }
    Serial.println();
    // Firebase.pushJSON(fbdo, "/NL4A", json)
    if (Firebase.updateNode(fbdo, "/NL4A", json))
    {
      // Print firebase server response
      /*Serial.println("PASSED");
        Serial.println("PATH: " + fbdo.dataPath());
        Serial.println("TYPE: " + fbdo.dataType());
        Serial.println("ETag: " + fbdo.ETag());*/
    }
    else
    {
      Serial.println("FAILED");
      Serial.println("REASON: " + fbdo.errorReason());
      Serial.println("------------------------------------");
      Serial.println();
    }
  }
}
