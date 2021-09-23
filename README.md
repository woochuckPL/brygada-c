# brygada-c
Android application for storing working schedule of Team C.

# What is it?
Brygada-C is an application written for Team C members in one of polish companies. These members can see their own and their colleagues working schedule for entire year (shifts, vacations, days off). Some of members with propriate privileges can change schedule so it was up-to-date.

# Used technology
Java - View layer and logic layer.
SQL - SQLite database is used to store data received from external database.

# How it works?
User must sign in to see working schedule.
Application connects with backend application deployed on VPS. That webapp is also written in Java and uses MySql server for storing data.
Data received from external database in json form is saved into local SQLite database and then displayed in form of a table.
Logged in users with propriate privileges can manipulate the data (changing shift for an employee, setting vacations, days off etc.) and send it to external database.
