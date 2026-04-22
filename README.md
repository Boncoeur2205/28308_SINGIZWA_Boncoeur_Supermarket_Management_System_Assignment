# 28308_SINGIZWA_Boncoeur_Supermarket_Management_System_Assignment

This repository contains the **Supermarket Management System** assignment.  
It includes the required files for submission:

- `Dockerfile` — multi‑stage build instructions to compile and run the JAR inside Docker
- `Supermarket_management_system.jar` — the compiled executable JAR file (included for reference)

---

## 🔹 Running with Docker (Recommended)

The provided Dockerfile uses a **builder stage** to compile Java source files and package them into a JAR, then a **runtime stage** to run the JAR.

### Step 1: Build the Docker Image
From the folder containing the Dockerfile:
```bash
**docker build -t supermarket-app .**

**Step 2: Run the Container**

Run in interactive mode so you can type input:

**docker run -it supermarket-app**

