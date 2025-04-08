# Genius-Project
# 🎵 Sepi's Genius - Java Music Platform

## 📌 Project Overview

**Sepi's Genius** is a Java-based command-line music platform inspired by [Genius.com](https://genius.com). The application allows users and artists to interact with a music database by creating accounts, logging in, adding songs, searching for albums/songs, commenting, and liking tracks. All data is stored and managed via plain text files.

---

## 📁 Project Structure


---

## 🚀 Features

### 👥 Account Management
- Create accounts as either `User` or `Artist`
- Email validation and age verification
- Username duplication check
- Data stored in `Users.txt` and `Artists.txt`

### 🔐 Login
- Authenticate by username, password, and role
- Supports both Users and Artists

### 🎶 Song & Album Features
- **Artists** can add songs to the database (title, album, lyrics)
- **Users** can:
    - Search for songs by name and view lyrics
    - Search for albums by title and see metadata
    - Like and comment on songs

### 📄 Data Storage
All data is stored in local text files using `|` as the field delimiter.

- `Users.txt`: Stores user accounts
- `Artists.txt`: Stores artist accounts
- `Albums.txt`: Album title, artist name, year, etc.
- `Songs.txt`: Song name, album, lyrics, comments, likes

---

## 🧪 How to Run

1. Clone the repository or download the project files.
2. Open the project in your Java IDE (e.g., IntelliJ, Eclipse).
3. Make sure file paths are valid for your system.
4. Run `Main.java`.
5. Use the menu to interact with the application.

---

## 🧠 Example Use

```text
Choose Your Option:
    a. Create A New Account
    b. Log In
    c. Add Song (Only Artists)
    d. Search For A Song
    e. Search for An Album
    f. Exit
