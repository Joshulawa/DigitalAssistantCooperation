<h1>DAComms</h1> 
<h3> Previously 2022-DigitalAssistantCooperation </h3>

<p align="center">
  <img src="https://github.com/spe-uob/2022-DigitalAssistantCooperation/blob/main/documentation/logo.png"  alt="DAComms Logo"/>
</p>

We were originally working on the open source Stanford Digital Assistant "Genie" to enable interaction between "Artificial Intelligences" via messaging servers to help establish social interaction and cooperation. 

In our research stage, we came across several issues, notably
+ <b>USA Based</b>: Genie requires us to consent to their terms in order to run our own Genie Home Instance (necessary for development), however, their terms require us to be residents of the United States. As such, we couldn't develop add-ons to Genie specifically.
+ <b>Activity</b>: Genie is very inactive, both in terms of development and user base. We are hoping to create something that positively impacts the AI/Online Communications space, if we were to base ourselves entirely on Genie, that'd be impossible.

After realising these issues, we drafted a "re-shift" of focus, which you can read "KitOpieProposal3.odt". This document includes more details on the issues with Genie, and more details on our shift to:

Creating a multi service communication platform which can integrate with any 3rd party services, including Artificial Intelligence/Home Assistant platforms.

Alongside Dr Kit Opie we hope this interactive and user controlled communication solution could create a precedent for more social AI’s that work for you, with the interest of you. 

## CONTENTS 
+ Development
+ Project progression
+ Gantt chart
+ Stakeholders
+ User stories

## Deployment Instructions
###  Downloads
  - [java](https://www.java.com/en/download/help/download_options.html)
  
  - [docker](https://docs.docker.com/get-docker/) (We recommend you download Docker Desktop)
  
  - [maven](https://maven.apache.org/download.cgi)

### Setup - Clone the Repository.
First get a local copy of the repository. You can either:
 - A. Clone the repository from the command line which requires authentication via SSH or a Personal Access Token(Eg, git clone https://github.com/spe-uob/2022-DigitalAssistantCooperation.git) 
 
 - B. Download the repository from GitHub as a Zip file and extract the files locally.

### 1. Creating and running the Database container.

First we will create a network for your containers to interact on.

Open your terminal and run the command:

```docker network create dacomms```

Then create a MySQL container:

```docker run --name mysql --network dacomms -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=coredb -d mysql```

### 2. Creating and running the Spring Server container.

In the terminal, go into the repository you cloned and navigate to the \Spring folder.

```cd code\core\Spring```

Create and run the spring server container:

```
docker image build -t spring-server .
docker container run --network dacomms --name spring-server-container -p 8080:8080 -d spring-server
```
   
### 3. Check the containers were built successfully.

```docker ps``` 

should list 2 containers with the names mysql and spring-server-container.

### ADD SECTION ABOUT USING DOCKER DESKTOP TO MONITOR CONTAINERS.

## Project progression 
While working on and researching this project we came across some obstacles that made us reevaluate our approach. Our client, Dr Kit Opie, had envisioned the use of the Stanford open source digital assistant 'Genie', which required consent to our data if we were to implement it within our own project - this wasn't possible since due to different UK/US data laws we had to be US citizens. Implementing the Genie language ThingTalk also proved difficult as Genie itself was not widely used enough and there was less information at our disposal to properly implement the functionality we wanted. Our client's vision for AI which involved natural language processing and intelligent contact management was achievable to a point, but in order to move forward we had to focus the functionality on more specific scenarios. 
Here is our [new project proposal](https://github.com/spe-uob/2022-DigitalAssistantCooperation/blob/main/KitOpieProposal3.odt), in which we refined our project goal while still keeping Dr Kit Opie's original interests in mind. Particularly from an anthropological perspective, we wanted to, without the use of Genie, create a digital assistant which was specifically in the interest of the user, not private company affiliated, which would positively impact the way we communicate with each other using mutiple interfaces. 

## Gantt chart
[Link to gantt chart](https://github.com/spe-uob/2022-DigitalAssistantCooperation/blob/main/Project%20Management/Software%20Engineering%20Project%20Gantt%20chart.xlsx "Project Gantt Chart")

 ## Initial stakeholders
 
 Internal StakeHolders: 
 
 • Team member            • Hiromichi Yano, 
                          • Joshua Ward, 
                          • Hannah Kent, 
                          • Xander Forrest

 • Mentor                 • Emerson Suter

External StakeHolders:  

 • Client (Dr Kit Opie) Anthropology and Archaeology Department, University of Bristol.
 
 • User of Genie Digital Assistant Cooperation.
 
 ## User Stories

Messaging assistant would be suited to users who benefit from collating communication across platforms, thus integrating multiple forms of messaging into a single entity and managing contacts in terms of messaging frequency. For this reason our messaging assistant would be tailored to a user base including:
+ coursemates that would want to easily contact each other, and by having access to group chats and setting up a friend list of regular contacts it will be easier to reach uni points of contact, allowing users to ask for help on assignments or lecture notes, as well as having an easily accessible list of people within the uni who help them the most
+ friends who message each other across multiple platforms - having a friend list based on closeness allows people to stay in touch, ask to catch up or check in in which the messaging assistant can establish who people's closest friends are
+ professionals and colleagues keeping a client list or having a way of communicating with people they are working on a project with, especially if it involves a large team of people who can be reached in various ways. This will encourage ease of collaboration, with our assistant adapting to a more formal and professional context. 

Throughout the progression of this project, our goal has become more tailored and user specific - in early development we imagined a range of possibilities for a digital assistant, and with our slight change of trajectory some of these are no longer relevant. The old user stories are linked here:
[outdated user stories](https://github.com/spe-uob/2022-DigitalAssistantCooperation/blob/readme/User%20Stories%20(old))

## Ethical considerations and data

We will require user data such as name, email, phone number to create a database of contact details for our service, but the database is designed to be self hosted by the user at this current point. In future we might consider a more centralised database, but the emphasis of our platform is security and privacy, as it does not store the content of messages sent and will never require very personal data such as ethnicity, religion, sexuality or home address/location. The primary goal of our digital assistant is to facilitate communication across platforms for multiple contacts, and so where it serves as an intermediary between two users the data needed is limited only to contact details with no third party accessing it which yields very few ethical concerns.

