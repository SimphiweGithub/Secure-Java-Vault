# Local Password Fortress (Java + MySQL)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Security](https://img.shields.io/badge/Security-SHA256-blue?style=for-the-badge&logo=guardian&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-000000?style=for-the-badge&logo=mysql&logoColor=white)

##  Project Overview
A locally hosted, cryptographically secure password manager built with **Java** and **MySQL**. Unlike cloud managers, this application ensures zero-knowledge privacy by keeping all data on the user's local machine, secured behind industry-standard hashing algorithms.

##  Security Architecture

* **Hashing:** User master passwords are never stored in plain text. They are hashed using **SHA-256** (or PBKDF2).
* **Salting:** Unique salts are generated for each entry to prevent Rainbow Table attacks.
* **Secure Persistence:** Uses **JDBC PreparedStatement** to strictly prevent **SQL Injection** attacks.
* **Memory Safety:** Sensitive strings are cleared from memory immediately after use.

##  Tech Stack
* **Core Logic:** Java (SE)
* **Database:** MySQL
* **Build Tool:** Ant
* **Security:** `java.security.MessageDigest` / `javax.crypto`

##  Key Features
* **Strong Password Generator:** Automates the creation of high-entropy passwords (uppercase, symbols, numbers).
* **Clipboard Security:** Auto-clears the clipboard after 60 seconds (simulated).
* **CRUD Operations:** Securely Add, Read, Update, and Delete credentials.

##  Disclaimer
This project was built for **educational purposes** to demonstrate applied cryptography and secure coding practices.
