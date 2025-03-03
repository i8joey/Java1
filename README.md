Scenario -
A travel agency has recently launched a complete overhaul of their front-end vacation bookings application using Angular and JavaScript. Lately, the front-end engineers have encountered various undocumented bugs when sending requests and fetching data from the back-end. Since the back-end was built in the early 1990s and the original developer has since retired and can no longer help troubleshoot, the existing team is concerned about the growing tech debt and lack of ongoing support. Your chief technology officer (CTO) decided to create a project to port over any mission-critical functionalities to a modern framework and has selected you, a software developer in Java, to start developing the minimally viable product (MVP) to migrate the legacy back-end to the modern Spring framework.

This project was done in a lab environment with an existing MySQL database and Angular front end.

Constructed controllers, entities, dao, and services

Wrote code for entities, including entity classes and the enum designed to match the UML diagram

Wrote code for dao, including repository interface for entities that extend JpaRespority, and added cross-origin support

Wrote code for the services package that included each of the following:
•    a purchase data class with a customer cart and a set of cart items
•    a purchase response data class that contains an order tracking number
•    a checkout service interface
•    a checkout service implementation class

Wrote code to include validation to enforce the inputs needed by the Angular front-end

Wrote code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders

Added 5 sample customers to the application 
