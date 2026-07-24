# Quantum Radar

## Overview
Quantum Radar is a Java-based traffic violation detection system designed using Object-Oriented Programming principles.

The system receives vehicle observations and applies configurable rules to detect violations and generate fines.

## Features
- Process vehicle observations:
  - Plate number
  - Date
  - Car type
  - Speed
  - Seatbelt status

- Detect traffic violations based on configurable rules.
- Generate fines containing:
  - Violations details
  - Fees
  - Total amount

- Retrieve:
  - Total fines per vehicle plate number.
  - Violated rules count.

## Implemented Rules
- Private cars speed limit: 80 km/h.
- Trucks speed limit: 60 km/h.
- Seatbelt must be fastened.

## Design
The system follows an extensible rule-based design:
- Radar depends on the `Rule` abstraction.
- New rules can be added without modifying the radar implementation.

## Technologies
- Java
- Object-Oriented Programming
- Java Collections
