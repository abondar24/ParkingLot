# ParkingLot

## Description
A multi-storey parking lot that can hold up to 'n' cars at any given point in time.
Each slot is given a number starting at 1 increasing with increasing distance from the
entry point in steps of one. An automated ticketing system that
allows customers to use parking lot without human intervention must be created.

When a car enters  parking lot,a ticket issued to the driver. The
ticket issuing process includes us documenting the registration number (number plate)
and the colour of the car and allocating an available parking slot to the car before
actually handing over a ticket to the driver. The customer should be
allocated a parking slot which is nearest to the entry. At the exit the customer returns
the ticket which then marks the slot they were using as being available.
Due to government regulation, the system should provide me with the ability to find
out:
• Registration numbers of all cars of a particular colour.
• Slot number in which a car with a given registration number is parked.
• Slot numbers of all slots where a car of a particular colour is parked.
The system is interacted via a simple set of commands which produce a specific
output. The system should allow input in two
ways. 

1) It should provide us with an interactive command prompt based shell where
commands can be typed in.

```yaml
nput:
park KA-01-BB-0001 Black
Output:
Allocated slot number: 3
Input:
park KA-01-HH-7777 Red
Output:
Allocated slot number: 4
Input:
park KA-01-HH-2701 Blue
Output:
Allocated slot number: 5
Input:
park KA-01-HH-3141 Black
Output:
Allocated slot number: 6
Input:
leave 4
Output:
Slot number 4 is free
Input: status
Output (Tab delimited output):

        No      Registration Slot No.  Colour
        1      KA-01-HH-1234          White
        2      KA-01-HH- 9999         White
        3      KA-01-BB- 0001         Black
        5       KA-01-HH-2701          Blue
        6       KA-01-HH-3141         Black

Input:
park KA-01-P-333 White
Output:
Allocated slot number: 4
Input:
park DL-12-AA-9999 White
Output:
Sorry, parking lot is full
Input:
registration_numbers_for_cars_with_colour White
Output:
KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333
Input:
slot_numbers_for_cars_with_colour White
Output:
1, 2, 4
Input:
slot_number_for_registration_number KA-01-HH-3141
Output:
6
Input:
slot_number_for_registration_number MH-04-AY-1111
Output:
Not found

```
2) It should accept a filename as a parameter at the command prompt and read the
commands from that file.
```yaml
./parking_lot file_inputs.txt
Input (contents of file):
create_parking_lot 6
park KA-01-HH-1234 White
park KA-01-HH-9999 White
park KA-01-BB-0001 Black
park KA-01-HH-7777 Red
park KA-01-HH-2701 Blue
park KA-01-HH-3141 Black
leave 4
status
park KA-01-P-333 White
park DL-12-AA-9999 White
registration_numbers_for_cars_with_colour White
slot_numbers_for_cars_with_colour White
slot_number_for_registration_number KA-01-HH-3141
slot_number_for_registration_number MH-04-AY-1111
Output (to STDOUT):
Created a parking lot with 6 slots
Allocated slot number: 1
Allocated slot number: 2
Allocated slot number: 3
Allocated slot number: 4
Allocated slot number: 5
Allocated slot number: 6
Slot number 4 is free


        No      Registration Slot No.  Colour
        1      KA-01-HH-1234          White
        2      KA-01-HH- 9999         White
        3      KA-01-BB- 0001         Black
        5       KA-01-HH-2701          Blue
        6       KA-01-HH-3141         Black
Allocated slot number: 4
Sorry, parking lot is full
KA-01-HH-1234, KA-01-HH-9999, KA-01-P-333
1, 2, 4
6 Not found
```
### Build and run

```yaml 
mvn clean install

./parking_lot or ./parking_lot <command> <params>

```
