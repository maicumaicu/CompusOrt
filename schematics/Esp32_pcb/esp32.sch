EESchema Schematic File Version 4
EELAYER 30 0
EELAYER END
$Descr A4 11693 8268
encoding utf-8
Sheet 1 1
Title ""
Date ""
Rev ""
Comp ""
Comment1 ""
Comment2 ""
Comment3 ""
Comment4 ""
$EndDescr
$Comp
L esp32-devkit-v1:ESP32-Devkit-V1 U1
U 1 1 60FAFDA6
P 3150 2350
F 0 "U1" H 3700 2565 60  0001 C CNN
F 1 "ESP32-Devkit-V1" H 3700 2445 79  0000 C CNN
F 2 "DOIT_ESP32:DOIT_ESP32_Devkit" H 3150 2350 60  0001 C CNN
F 3 "" H 3150 2350 60  0001 C CNN
	1    3150 2350
	1    0    0    -1  
$EndComp
Wire Notes Line
	2500 2000 5000 2000
Wire Notes Line
	5000 2000 5000 4800
Wire Notes Line
	5000 4800 2500 4800
Wire Notes Line
	2500 4800 2500 2000
Text Notes 4650 4750 0    50   ~ 0
ESP-32\n
Text Label 2950 2700 2    50   ~ 0
Vcc
Text Label 4450 2650 0    50   ~ 0
GND
$Comp
L Connector:Conn_01x04_Female J2
U 1 1 60FB18E8
P 5912 2297
F 0 "J2" H 5940 2227 50  0000 L CNN
F 1 "Conn_01x04_Female" H 5940 2182 50  0001 L CNN
F 2 "Connector_PinHeader_2.54mm:PinHeader_1x04_P2.54mm_Vertical" H 5912 2297 50  0001 C CNN
F 3 "~" H 5912 2297 50  0001 C CNN
	1    5912 2297
	1    0    0    -1  
$EndComp
Text Label 6412 2417 0    50   ~ 0
Vcc
Text Label 6275 3100 0    50   ~ 0
DP(D2)
Text Label 2950 3050 2    50   ~ 0
DP(D2)
Text Label 2950 3750 2    50   ~ 0
CEP(D15)
Text Label 5775 3300 2    50   ~ 0
CP(D5)
Text Label 2950 3350 2    50   ~ 0
CP(D5)
Text Label 6275 3300 0    50   ~ 0
LP(D4)
Text Label 2950 3250 2    50   ~ 0
LP(D4)
Text Label 5712 2197 2    50   ~ 0
GND
Text Label 5712 2297 2    50   ~ 0
Vcc
Text Label 5712 2397 2    50   ~ 0
SDA
Text Label 5712 2497 2    50   ~ 0
SCL
Text Label 4450 3050 0    50   ~ 0
SCL
Text Label 4450 2950 0    50   ~ 0
SDA
Wire Notes Line
	5475 2000 6625 2000
Wire Notes Line
	6625 2000 6625 3500
Wire Notes Line
	6625 3500 5475 3500
Wire Notes Line
	5475 3500 5475 2000
Text Notes 6175 3475 0    50   ~ 0
Conectores\n
Text Label 6275 3000 0    50   ~ 0
CEP(D15)
Text GLabel 4700 2650 2    50   Input ~ 0
GND
Wire Wire Line
	4450 2650 4700 2650
$Comp
L Connector:Screw_Terminal_01x02 J3
U 1 1 6110B675
P 6212 2417
F 0 "J3" H 6130 2184 50  0000 C CNN
F 1 "Screw_Terminal_01x02" H 6292 2318 50  0001 L CNN
F 2 "TerminalBlock:TerminalBlock_bornier-2_P5.08mm" H 6212 2417 50  0001 C CNN
F 3 "~" H 6212 2417 50  0001 C CNN
	1    6212 2417
	-1   0    0    1   
$EndComp
$Comp
L Connector_Generic:Conn_02x05_Odd_Even J1
U 1 1 60FB67CB
P 5975 3100
F 0 "J1" H 6025 3517 50  0000 C CNN
F 1 "Conn_02x05_Odd_Even" H 6025 3426 50  0000 C CNN
F 2 "Connector_IDC:IDC-Header_2x05_P2.54mm_Vertical" H 5975 3100 50  0001 C CNN
F 3 "~" H 5975 3100 50  0001 C CNN
	1    5975 3100
	1    0    0    -1  
$EndComp
Text Label 6412 2317 0    50   ~ 0
GND
$EndSCHEMATC
