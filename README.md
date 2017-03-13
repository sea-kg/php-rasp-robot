# rasprobotd

## System 

* Minimal Debian 8.0 jessi

## Find rasp in network

	$ nmap -sn 192.168.1.1/24

## WiFi scan

	$ iwlist wlan0 scan

## Configure wifi

	$ sudo apt-get install wireless-tools wpasupplicant

	auto wlan0
	iface wlan0 inet dhcp
	  wpa-ssid "ssid"
	  wpa-psk "pass"

## Compile rasprobotd

	$ sudo apt-get qt5-default
	
	
## Schema (v201703)

![pic](https://raw.githubusercontent.com/sea-kg/rasprobotd/master/images/schema_v201703.png)
