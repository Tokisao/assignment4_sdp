# Assignment #4 — Facade Pattern

**Name:** Zharylgapova Dayana<br>
**Group:** SE-2538

## Description
This repository contains an implementation of the Facade structural design pattern in Java. The project simulates an **Online Order Processing System**

The `OrderFacade` acts as a simplified interface to a complex underlying subsystem, coordinating inventory reservations, payment processing, shipping logistics, and customer notifications. It also implements automatic rollback mechanisms without exposing this complexity to the client.

## Folder Structure
```text
src/
├── datamodel/          # Data transfer objects (Cart, Customer)
├── subsystem/          # Complex subsystem classes (Inventory, Payment, Shipping, Notification)
├── facade/             # The simplified API (OrderFacade)
└── client/             # The Client application using the Facade
```

## How to Run
1. Navigate to the `src` directory.
2. Compile the classes: `javac client/Client.java`
3. Run the application: `java client.Client`
