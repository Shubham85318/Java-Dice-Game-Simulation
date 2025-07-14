#  Dice Game Simulation – Java

 
This is a little Java project I worked on as part of a full-stack developer take-home test.

The task was to simulate a simple dice game using 5 dice, run it 10,000 times, and analyze the results. The rules are interesting and a bit different from standard dice games — check them out below!

---

##  Game Rules 

- Start with 5 dice.
- Roll them all.
- If **any 3s** show up → remove *all* 3s → that roll scores **zero**.
- If there are **no 3s** → remove the **lowest value die** → add that value to the total score.
- Repeat with the remaining dice until you're out of dice.
- The **final score** is the sum of all non-zero scoring rounds.

Simple idea, but it makes for fun logic to code.

---

##  Tools Used

- Java 17 (OpenJDK – Temurin build)
- Written and tested in **VS Code**
- Used `java.util.*` for lists, random numbers, and basic utilities

---

##  How to Run It

If you’ve got Java 17+ set up, just do this:

```bash
javac DiceGameSimulation.java
java DiceGameSimulation
