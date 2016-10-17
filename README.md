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
	
	
## Elements

### Raspberry Pi v2

You can find this in Internet

### Engines (gearmotor) Gekko MR12-030

	Example: http://www.robototehnika.ru/e-store/catalog/198/1192/

- Спецификация:
- Рабочее напряжение: 3 - 9 В
- Номинальное напряжение: 6 В
- Передаточное отношение: 30:1
- Скорость без нагрузки: 400 об/мин
- Ток без нагрузки: 40 мА
- Ток при блокировке: 360 мА
- Крутящий момент: 0,35 кг*см
- Диаметр вала: 3 мм
- Размер (ДхШхВ): 25 x 12 x 10 мм
- Вес: 10 гр
- Размерность: MICRO
- Материал шестеренок: Металл

### Driver for motors

Example http://www.robototehnika.ru/e-store/catalog/203/1176/

Спецификация:

- Двойной H-мост позволяет управлять двумя двигателями постоянного тока или одним шаговым
- Рабочее напряжение: 2,7 - 10,8 В
- Выходной ток: 1,2 A (пиковый 2 A) на двигатель
- Выводы могут быть соединены параллельно для увеличения тока до 2,4 A (пиковый 4 A) для управления одним двигателем
- Входное напряжение: 3 В и 5 В
- Блокировка питания при падении напряжения и защита от перегрева и перегрузки по току
- Защита от переполюсовки питания
- Ограничение по току можно обеспечить путем добавления резисторов (в комплект поставки не входят)


### power bank (for raspberry)

Внешний аккумулятор INTER-STEP PB3000 LED c фонариком, Black/Red
PB3000 LED (1050 rur)

- 3000mh Li-lon

### Connection motors to raspberry

todo
