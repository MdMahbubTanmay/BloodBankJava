
# Blood Bank Management System 🩸

* New Version Available both for windows and Linux : [🩸Download Now🩸](https://github.com/MdMahbubTanmay/BloodBankJava/releases/tag/BloodBankJava_V1)

A robust and efficient Java-based application designed to bridge the gap between blood donors and recipients. This system streamlines the management of blood stocks, donor records, requests, and distributions to ensure quick availability during medical emergencies.

---

## 🚀 Features

- **Donor Management:** Register new donors, track eligibility criteria, and maintain comprehensive health logs.
- **Stock Control:** Monitor available blood groups ($A+, A-, B+, B-, AB+, AB-, O+, O-$) in real-time with critical low-stock alerts.
- **Recipient & Request Tracking:** Seamlessly process blood requests from hospitals or individuals and verify compatibility.
- **User Authentication:** Secure login system with role-based access control (e.g., Admin, Staff, Donor).
- **Search & Filter:** Advanced querying to find eligible donors by location and blood group instantly.
- **Reporting:** Generate insightful summary reports on blood collections and distributions.

---

## 🛠️ Tech Stack

- **Language:** Java (JDK 11 or higher)
- **GUI Framework:** Java Swing / JavaFX *(Update based on your UI)*
- **Database:** MySQL / PostgreSQL *(Update based on your DB)*
- **Build Tool:** Maven / Gradle / Native IntelliJ Project
- **Database Connectivity:** JDBC

---

## 📋 Prerequisites

Before running the project, ensure you have the following installed:
- [Java Development Kit (JDK 11+)](https://www.oracle.com/java/technologies/downloads/)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- An IDE (IntelliJ IDEA, Eclipse, or NetBeans)

---

## ⚙️ Setup and Installation

### 1. Clone the Repository
```bash
git clone [https://github.com/MdMahbubTanmay/BloodBankJava.git](https://github.com/MdMahbubTanmay/BloodBankJava.git)
cd BloodBankJava

```

### 2. Database Configuration

1. Open your MySQL client (e.g., MySQL Workbench or terminal).
2. Create a database named `blood_bank`:
```sql
CREATE DATABASE blood_bank;

```


3. Import the provided schema/SQL file (if applicable):
```bash
mysql -u your_username -p blood_bank < database.sql

```


4. Update the database credentials in your configuration file (e.g., `db_config.properties` or database connection class):
```java
String url = "jdbc:mysql://localhost:3606/blood_bank";
String user = "your_username";
String password = "your_password";

```



### 3. Build and Run

**Using an IDE:**

* Open the project folder in IntelliJ IDEA or Eclipse.
* Let the IDE load dependencies.
* Locate the main class (e.g., `Main.java` or `App.java`) and click **Run**.

**Using Command Line (Maven example):**

```bash
mvn clean install
mvn exec:java -Dexec.mainClass="com.project.Main"

```

---

## 🏗️ Architecture / System Flow

The application follows standard software engineering principles for reliability and scalability:

1. **Authentication Layer:** Secures administrative and staff functionalities.
2. **Business Logic Layer:** Validates blood donor eligibility intervals and matching rules.
3. **Data Access Layer:** Handles secure transactions with the relational database to prevent data discrepancies.

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📝 License

Distributed under the MIT License. See `LICENSE` for more information.

---

## ✉️ Contact

Md Mahbub Tanmay - [@MdMahbubTanmay](https://github.com/MdMahbubTanmay)

Project Link: [https://github.com/MdMahbubTanmay/BloodBankJava](https://github.com/MdMahbubTanmay/BloodBankJava)

```