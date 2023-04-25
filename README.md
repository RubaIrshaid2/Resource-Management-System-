# **Memory Allocation Web Service**

This is a Java-based RESTful API web service that provides memory allocation on a server.
The system aims to allocate memory from existing servers first, then from servers being created, and if no server is available, create a new one.
all of that done virtually.

## Installation

1. Clone the repository to your local machine:
git clone [https://github.com/RubaIrshaid2/memory-allocation-web-service.git](https://github.com/RubaIrshaid2/Resource-Management-System-)

2. Open the project in your favorite Java IDE (e.g. Eclipse, IntelliJ IDEA, NetBeans).
3. Build the project using Gradle

## Usage
**Endpoints**

The following endpoints are available:

GET booking/all: Returns a list of all existing serversand their details.

POST booking : Allocates memory on a server. The request body should contain a JSON object with a size field indicating the amount of memory to allocate (in GB).

## Example Requests

Request:

POST /booking

70
    

Response:

{

    "id": 0,
    
    "name": "server_0",
    
    "freeMemory": 30,
    
    "active": true
    
}

### **Notes**
. The system will not overbook servers.

. The maximum capacity of a server is 100 GB.

. The system can handle multiple allocation requests simultaneously.
