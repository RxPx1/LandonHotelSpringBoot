Rob Pavlik\
D387 Advanced Java\
StudendId# 010779327
Repo - https://gitlab.com/wgu-gitlab-environment/student-repos/rpavli5/d387-advanced-java/-/tree/WorkingBranch

Changed to D387 Project-

**C1**
1. Created WelcomeController that has multithreading methods for getting the English Welcome message and the French Welcome Message. Added Mapping

2. Line Changes in app.component.ts

        a. 19-21 - added welcomeMessageEN and welcomeMessageFR string varibles.\

        b. 35-36 - called the getWelcomeMessageEN and getWelcomeMessageFR functions to the ngOnInit functions\

        c. 53- 65 - creted the methods for getting the GET request from the WelcomeController and returning the welcome messages

3. Line Changes in app.component.html

        a. 11 -12 - added two P tags and styling for those P tags - in the tags I call the welcomeMessage varibles

**C2**

1. Added changes to the app.component.html file to add CA$ and € to the room price

2. Line changes to app.component.html

        a. 79 - 81 - Added two more room.price varibles and changed the currency symbols to add CA$ and € then added conversion to current rates and added Math.round so that the prices stay in whole dollars.

**C3**

1. Created TimeController Class in Spring with mapping  and crossorgin support. Added a Method to take a predefined time and convert it to EST, MST and UTC.

2. In the WelcomeController Class Intellj suggested I simplfy my return resonse

3. In app.compnent.ts I added a varible named response to hold the times conversions in. Created a function for pulling the get request from the TimeController class. and then called that funciton in the ngOnInit function- Line Changes

        a. 22 - added the response varible

        b. 38 - called the getTimeConverter function inside the ngOnInit function

        c. 56-64 - created teh getTimeConverter funciton to pull the GET request from the TimeController.java class.

4. In the app.component.html I added the Live Presentation information and then called the varibles holding the time conversions to display on the page

        a. 28-29 - Added p tag and styling for the Live Presentation information

        b. 30-34 - implemented the varibles and called each time conversion independtly so they show up on different lines. 

D2

D3
