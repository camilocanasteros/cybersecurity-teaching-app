# NetShield - Cybersecurity Learning App

## Overview
NetShield is an educational cybersecurity mobile application that helps students understand real-world cyber threats such as phishing, malware, ransomware, and SQL injection through interactive and accessible content.

The application includes a secure authentication system and is designed for users with little or no prior knowledge of cybersecurity.

---

## Features
- User registration system
- Secure login with password hashing (bcrypt)
- Educational content about cybersecurity topics:
  - Phishing
  - Ransomware
  - Malware
  - SQL Injection
- Security tips for safer internet usage
- Future features:
  - Interactive mini-games
  - Cybersecurity videos
  - User feedback surveys

---

## Technologies Used
- Android (Java)
- PHP (Backend API)
- MySQL (Database)
- XAMPP (Local development server)
- Volley (HTTP requests)

---

## Architecture
Android Application → PHP API → MySQL Database

---

## Project Structure

netsshield/
│
├── android-app/     # Android application
├── backend/         # PHP files (API)
├── database/        # SQL database script
├── README.md
└── .gitignore

---

## Installation

### Backend (XAMPP)
1. Install XAMPP  
2. Move backend files to:  
   htdocs/netsshield/  
3. Start Apache and MySQL  
4. Import the database:
   - Open phpMyAdmin  
   - Create a database  
   - Import database/database.sql  

---

### Android App
1. Open project in Android Studio  
2. Update your local IP address in the code:  
   http://YOUR_IP/netsshield/  
3. Run the application on emulator or device  

---

## Security
Passwords are securely stored using bcrypt hashing through the backend, ensuring that user credentials are protected and not stored in plain text.

---

## Purpose
This project was developed to raise awareness about cybersecurity among students and provide an accessible way to learn about common cyber threats and how to prevent them.

---

## Future Improvements
- Gamification features  
- Interactive cybersecurity simulations  
- Video learning modules  
- Improved UI/UX design  

---

## Screenshots


---

## Author
Camilo Canasteros

---

## Notes
This project is intended for educational purposes and demonstrates the integration of a mobile application with a backend API and database.
