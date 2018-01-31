# _National Parks API_

#### _An application program interface that serves details on National Parks across America.The application uses many-to-many relationships._

#### By _**Kate Trahan**_

## Description

_This is an API that uses Java in order to serve detailed data on National Parks across America. The application will include details on the State the National Parks are in, including how many national parks are in that state. The application will also include information about the National Parks themselves including highest peak, how large they are, type of terrain, and if they are currently up for resizing under the our current administration.The application will also include tips such as where to stay, what to pack and where to donate if the parks are being considered for resizing. Created 1/26/2018._


### Specs
| Behavior | Input | Output |
| :-------------     | :------------- | :-------------
| **See one state**| "Oregon" | "Oregon" |
| **See specific information about a state**| "name, number of national parks, population" | "name, number of national parks, population" |
| **See list of national parks by state**| "Oregon" | "Crater Lake"|
| **See list of details about national parks** |"Zion National Park"| "Highest peak, size, how many people visit per year, up for resizing"
| **See what state a national park is in when searching** |"Crater Lake"|"Oregon"|
| **Leave a tip/url to donate to National Parks** | "Make sure to hike Angel's Landing"| "Make sure to hike Angel's Landing"|
| **Add National Parks(for future use) to database** | "Arches(revised)" | "Arches(revised)" |
| **Edit states**| "Oregn"|"Oregon"|
| **Edit national parks** | "Zion" | "Zion National Park" |
| **Delete reviews** | "National parks should be resized" | "" |


endpoints
/states/new
/states
/states/:id
/parks/new
/parks
/states/:id/park/:parkId
/parks/:id/states
/states/:id/parks
/park/:parkId/tips/new
/tips
/parks/delete




## Setup/Installation Requirements

* _Clone repository to your machine from GitHub_
* _Open cloned repository in IntelliJ_

## Known Bugs

_No known issues._

## Support and contact details

_If you have any issues or have questions, ideas or concerns please email kathrynceciliatrahan@gmail.com or contribute to the code_

## Technologies Used

* _Java_
* _IntelliJ_
* _JUnit_
* _Postman_
* _Trello_
* _h2database_
* _gson_
* _Json_


### License
Copyright (C) 2017 Kate Trahan

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with this program. If not, see https://www.gnu.org/licenses/.
