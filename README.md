# EscapeRoom

### Purpose

 This app is a choose your own adventure game. It is an app that shows some images and written narration that presents scenarios that allows the user to experience a story that they can affect at certain junctions with two options. The two options are presented on two buttons that show up at the bottom of the screen. A button will present an action that will affect what scenario is presented next.

 My goal for this app is to provide a fun way to interact with a story where a user can affect the outcome. To add to the some random elements to the story, I use the temperature of the city the user is located (currently it only calls temperature from Albuquerque, New Mexico) to change what scenarios are presented. This feature adds to the replayability to the game.Additionally, this app is meant to show that I can use a number of features, components and techniques that were presented in the Java + Android bootcamp at CNM Ingenuity.

  * Consuming web services with Retrofit & OkHttp.
  * Deserializing JSON data with Gson & the Retrofit Gson converter.
  * Basic use of the Room ORM components.
  * Basic use of a List View.
  * Simple management of fragments in a navigation view-oriented app.
  * Definition & use of different types of menus: navigation, option, and context.
  * Basic operations on internal & external files.
  * Explicit permission requests.
  
### Current State

The app is fully operation for testing/pre-release use:

  * Images, buttons, and titles load when in correct order when a button is pressed.
  * The call to the OpenWeatherMap API works as intended.
  * Preload of the database using CSV files work as intended.
  
# Testing  

### Operations
 * Inserting and retrieving a scenario from the Scenario Table in the local database.
 * Going to a dialogue fragment from the collapsing menu from the scrolling activity.

# Environments

### Physical Device
  * Galaxy S10, Android 9(API28)
### Emulators
  * Nexus 5X(API 28)

# Third Party Resources
  
### Libraries
 + [Google Gson](https://github.com/google/gson)
 + [Retrofit 2](https://square.github.io/retrofit/)
 + [Facebook Stetho](https://github.com/facebook/stetho)
 + [Glide](https://github.com/bumptech/glide)
 + [Room](https://developer.android.com/topic/libraries/architecture/room)
 + [Play Services Plus](https://developers.google.com/android/guides/releases)

## External Sources
 + [Open Weather Map API](https://openweathermap.org/api)
 
 # Potential Improvements
 
### Functional Goals
 * Implement google sign in.
 * Implement the User table and ActionHistory table in the local database so that users can store their progress.
 * Implement the dialogue fragment to display user history from the local database.
 * Add more Scenarios to the database for a more robust experience.
### Cosmetic Improvements
 * Fix white bar in Scrolling View.
 * Add custom background for the Title background.
 * Create more Refined Art scenarios for the stories.
 
 
# Design & technical documentation
 + [Wireframes](Wireframe.html)
 + [ERD](ERD.html)
 + [DDL](docs/ddl.md)
 + [Javadoc](docs/api/)
# Copyrights and Licenses
Copyright 2019 Thomas Herrera & Deep Dive Coding
Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 + [Link to the Apache License](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 + [junit 4 License](https://junit.org/junit4/license.html)
 + [gson](https://github.com/google/gson/blob/master/LICENSE)
 + [stetho License](https://github.com/facebook/stetho/blob/master/LICENSE)

### User Stories

1. I am a user that enjoys a thrilling story. I would like the app to tell an engaging story that I can be immersed in.

2. I am a user that likes to explore different paths in a game and see what the different ending are. I would enjoy the option to go back to previous junctions and choose other decisions so that I may see what the different paths lead to.

# Instructions
 * [Using the app](UserInstructions.html)
 * [Building the app](BuildInstructions.html)
 
 
 
For more details on current classes and methods, see [Javadoc](docs/api/) .
[DDL](docs/ddl.md)
