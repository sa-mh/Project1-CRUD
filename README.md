# Project1-CRUD

# Online Personal Reading List 
* Site:
* Site GIT:
* Jira Board:
* Presetation:

## Contents
* [Requirements](#requirements)
  * [My Approach](#my-approach)
* [Architecture](#architecture)
   * [Database Structure](#database-structure)
* [Project Tracking](#project-tracking)
* [Risk Assessment](#risk-assessment)
* [Testing](#testing)
* [Front-End Design](#front-end-design)
* [Known Issues](#known-issues)
* [Future Improvements](#future-improvements)
* [Authors](#authors)

## Brief

The requirements set for the project are below

* A Jira board with full expansion on user stories, use cases and tasks needed to complete the project.
* Clear Documentation from a design phase describing the architecture you will use for your project.
* A detailed Risk Assessment created at the beginning of your project.
* A relational database used to store data persistently for the project.
* A functional application created in the OOP language, following best practices and design principles, that you have covered during training, this application needs to meet the requirements set on your Kanban Board
* The application must have a functioning front-end website and integrated API.
* Fully designed test suites for the application you are creating, as well as automated tests for validation of the application.
* You must meet an acceptable level of test coverage in your backend and provide consistent reports and evidence that you have done so.
* Code fully integrated into a Version Control System
* Code built through a CI server
* Application deployed to a cloud-based virtual machine

## Current Features

To achieve the requirements set out in the brief, I have created a personal reading list site where a user can enter books that they have read or want to read including some basic information about the books including details such as:
* The title
* The author
* The genre
* Its reading status
* The length
* Book rating
* the ISBN
Users are able to add in these details for the books they want to add as well as edit and remove books that have already been entered.

## Architecture

The database is comprised of one table with the following properties:

* id - bigint - auto increment - primary key
* author - varchar(255)
* coverurl - varchar(255)
* genre - varchar(255)
* isbn - integer - not null
* pages - integer - not null
* rating - integer - not null
* status - varchar(255)
* title  -varchar(255)

## Project Tracking

The JIRA board can be found here : https://bookproject.atlassian.net/secure/RapidBoard.jspa?projectKey=SBP&rapidView=1&view=planning.nodetail&atlOrigin=eyJpIjoiNTM4NDM1MDFjNTFhNDFkNWIwNzNjZWI2NzZjNGU4NzEiLCJwIjoiaiJ9

## Risk Assessment

After assessing the risks of the issues and creating a risk register, I have deemed the project to be of very little risk. The biggest issues arising from the project are ones which are easily mitigated through careful use of source control or through careful testing and limitation of inputs. The full risk register can be found here: 

https://docs.google.com/spreadsheets/d/1kh8wnSfnVZ177rRehJY8zhEpChmSyrlAJuZadkajZGk/edit?usp=sharing

## Testing

The backend of project was tested though junit tests to make sure that books were being created, edited and removed properly and as expected. All tests created to test the methods passed succesfully and had an overall testing coverage  

## Front End Design

The front end of the website is extremely basic and underwhelming in its current form. The site consists of one page that can be split into three sections.

* Search Fields
* The Carousel
* The Input Fields

### Search Fields

The top section of the site is the input fields. While these are present in the design of the website they are not currently functional and serve no purpose other being placeholder for a future feature. 

The options have been split into three different fields:
* Author/Title
* Genre
* Reading Status

#### Author/Title

This search uses a select box as well as an input field. This allows the user to narrow down the search to either the title of a book or an author to allow for a more precise search should they want to.

#### Genre

The genre filter is a select box as there is a pre defined list of genres that the users can select from when inputting a books details. Using this prevents the user from inputting an incorrect value and allows for uniformity in the database. The list of genres is not fully completed as is currently more a proof of concept rather than a complete list of over 50 genres.

### The Carousel

The carousel is a boostrap element imported into the site. The carousel displays the covers for the books which are all currently set to a default image. If a custom URL is set for an image, the carousel will display that cover instead. The carousel is also linked to the input fields below and as such, will display the cover for the book that is having its details displayed in the input fields below. The left and right buttons on the carousel will change the book selected, as will selecting which book from the list underneath the covers.

### The Input Fields

The input fields in the bottom section of the page is where the vast majority of the information is shown and where the user has the most interaction. The input fields display the details of the book being shown which are disabled for user input/editing so that the user is unable to make any changes unless they make it clear that they want to through the use of the update button. This will then allow the fields to be changed which can they be either saved or cancelled by the user. If the user wants to add a new book, they can add the same book as the one already being shown if they so wish, or they can clear the details to empty the fields and input their own details to then add a new book. CLicking to remove a book will remove the book whos details are currently being desplayed in the fields.

Most of the inputs are standard inputs as they need to be custom inputs from the user however the Status and Genre boxes are selects with predefined values. This is to make sure that there is uniformity in the database and to allow for easier searching since all of the values are predefined. User error with issues such as spelling are also not an issues due to them being predefined.

## Known Issues

A known issue at the moment is that the bootstrap carousel may not go to the next/previous book if the user clicks the next/previous buttons too frequently and too quickly in an extremely short period of time. The issue that arises from this is that the carousel item may not move as much however the details for the item in the box may change, as such the cover and details may not be in sync with eachother. Adding a delay to the details in the boxes so that it timed with the movement of the items in the carousel assisted this and considerably reduced the chances of this happening however it was not a 100% fix.

Another known issue is that there are no checks on the user input on the client side. This means that the users are able to attempt to add incorrect details into the input fields. Such as attempting to enter the pages length of the book as 'One hundred' instead of entering it numerically.

There is an issue with the removing of books from the carousel. Previously when removing a book it removes the book from the database correctly however the item would not be removed from the carousel. When the item was shown it would show the details as being 'Undefined'. The method to create the carousel items is called which should create an entirely new carousel however this did not fix the issue. The current fix is to reload the webpage which works as a small list however if the list were to increase in size drastically this would not be a reasonable solution to the problem. It also loses the user their place in the list so that they would have to start from the first item in the list. A different solution is needed in order for it to be more practical.

## Future Improvements

The main future improvements in the future would be to fix the known issues listed above however once those are fixed, the changes mentioned below would be the main improvements.

One of the future features planned for the future are a search and filtering system so that users can search for certain authors or genres should they know what they would specifically like to see.

Another feature would be the custom book covers for different books. At present all of the covers are a default blank cover however in future the users should be able to able to change that cover either through inputing the ISBN so that it can be found from a third party site or through uploading their own image.

A change in CSS design would be necessary as the current design of the website is 

## Authors
