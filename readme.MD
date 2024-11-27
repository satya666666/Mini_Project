# Frontend Application for Admin Dashboard

## **Overview**
This application allows the admin of the organization to **create, read, update, and delete** specializations (e.g., *Theory & Systems*, *Data Science*, etc.). Additionally, it displays all the courses registered under a selected specialization.

---

## **Project Structure**

### **File Structure**
```
src/
├── components/
│   ├── Course.jsx                  # Component to manage individual course details
│   ├── CoursesDisplay.jsx          # Displays all courses under a selected specialization
│   ├── Dashboard.jsx               # Main admin dashboard for managing specializations
│   ├── DeleteSpecialization.jsx    # Allows deleting a specialization
│   ├── Login.jsx                   # Login page for the admin
│   ├── SpecializationForm.jsx      # Form to add/edit specializations
├── context/
│   ├── AuthContext.jsx             # Manages user authentication
├── services/
│   ├── api.js                      # Handles API requests for CRUD operations
├── App.css                         # Global styles for the app
├── App.js                          # Main app entry point
├── index.css                       # Additional styling
└── index.js                        # React entry point
```

### **Components Description**

1. **`Dashboard.jsx`**
   - Acts as the main admin panel.
   - Displays a list of specializations.
   - Allows navigation to manage courses and specializations.

2. **`SpecializationForm.jsx`**
   - Contains a form for adding or editing a specialization.
   - Fields include name, description, year, and other related details.

3. **`CoursesDisplay.jsx`**
   - Displays all courses associated with the selected specialization.
   - Admin can view, update, or delete courses.

4. **`DeleteSpecialization.jsx`**
   - Allows admins to delete an existing specialization.

5. **`AuthContext.jsx`**
   - Provides authentication context to ensure only admins can access the dashboard.

6. **`api.js`**
   - Contains all API calls (GET, POST, PUT, DELETE) to interact with the backend server.

---

## **Setup and Installation**

### **Prerequisites**
- **Node.js** (v14 or higher)
- **npm** or **yarn**

### **Steps to Run the Application**

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd <repository_folder>
   ```

2. **Install Dependencies**
   ```bash
   npm install
   ```

3. **Start the Application**
   ```bash
   npm start
   ```
   The app will run on [http://localhost:3000](http://localhost:3000).

4. **Environment Variables**
   - Create a `.env` file at the root level.
   - Add the following environment variables:
     ```
     REACT_APP_API_BASE_URL=http://<backend-server-url>
     ```

---

## **Features**

### **Specialization Management**
- **Add a Specialization**: Admins can create a new specialization by filling out the form in `SpecializationForm.jsx`.
- **Edit a Specialization**: Admins can update specialization details.
- **Delete a Specialization**: Specializations can be removed using the delete option in `DeleteSpecialization.jsx`.

### **Course Management**
- **View Courses**: Display all courses under a specific specialization using `CoursesDisplay.jsx`.
- **Edit Courses**: Modify course details in `Course.jsx`.
- **Delete Courses**: Remove a course from the system.

### **Authentication**
- Admin login functionality is implemented using `AuthContext.jsx` for state management.

---

## **API Endpoints**

The frontend interacts with the backend through the following endpoints:

1. **Specialization Endpoints**
   - `GET /api/specializations`: Fetch all specializations.
   - `POST /api/specializations`: Add a new specialization.
   - `PUT /api/specializations/:id`: Update a specialization.
   - `DELETE /api/specializations/:id`: Delete a specialization.

2. **Course Endpoints**
   - `GET /api/courses?specializationId=<id>`: Fetch all courses for a specialization.
   - `POST /api/courses`: Add a new course.
   - `PUT /api/courses/:id`: Update a course.
   - `DELETE /api/courses/:id`: Delete a course.

---

## **Usage Instructions**

1. **Login**:
   - Access the login page (`Login.jsx`) and enter admin credentials.

2. **Managing Specializations**:
   - Use the **Dashboard** to view, add, edit, or delete specializations.

3. **Managing Courses**:
   - Select a specialization from the list to view its associated courses.
   - Use the provided options to add, update, or delete courses.

---

## **Styling and Design**
- **CSS Files**: `App.css` and `index.css` provide global and component-level styling.
- **Responsive Design**: The app is optimized for desktop view but can be further improved for mobile responsiveness.

Below is an example of a **README.md** file for your backend project implemented in Spring Boot. It describes the structure, features, setup, and usage for handling course specializations.


# Academia Backend System

## **Overview**
This backend application allows employees of the admin department to **create, read, update, and delete** course specializations (e.g., *Theory & Systems*, *Data Science*). Additionally, it provides functionality to manage courses registered under each specialization. The system is built using **Spring Boot** and includes robust security mechanisms such as JWT-based authentication.

---

## **Project Structure**

### **Directory Overview**
```
com.satyam.academia/
├── config/
│   ├── SecurityConfig               # Configures JWT authentication and security
│   ├── WebConfig                    # Configures CORS and other web settings
├── controller/
│   ├── EmployeeController           # Handles CRUD operations for employees
│   ├── LoginController              # Handles user authentication and login
│   ├── SpecializationController     # Manages specializations (CRUD)
│   ├── SpecializationCourseController # Manages courses under a specialization
├── dto/
│   ├── CourseResponse               # Data transfer object for course responses
│   ├── EmployeeRequest              # DTO for employee-related requests
│   ├── LoginRequest                 # DTO for login requests
│   ├── SpecializationRequest        # DTO for creating/editing specializations
│   ├── SpecializationResponse       # DTO for specialization responses
├── entity/
│   ├── Course                       # Entity representing a course
│   ├── Department                   # Entity representing departments
│   ├── Employee                     # Entity representing employees
│   ├── Specialization               # Entity representing specializations
│   ├── SpecializationCourse         # Entity linking specializations and courses
├── helper/
│   ├── EncryptionService            # Handles password encryption
│   ├── JWTHelper                    # Handles JWT creation and validation
│   ├── RequestInterceptor           # Intercepts and validates HTTP requests
├── mapper/
│   ├── CourseMapper                 # Maps course entities to DTOs and vice versa
│   ├── SpecializationMapper         # Maps specialization entities to DTOs and vice versa
├── repo/
│   ├── EmployeeRepository           # Repository for employee CRUD operations
│   ├── SpecializationRepo           # Repository for specialization CRUD operations
│   ├── SpecializationCourseRepo     # Repository for managing specialization-course relationships
├── service/
│   ├── EmployeeService              # Business logic for employee management
│   ├── LoginService                 # Handles authentication logic
│   ├── SpecializationService        # Business logic for specialization management
├── resources/
│   ├── application.properties       # Configuration for the application
│   ├── data.sql                     # Sample data for testing the system
└── test/
    ├── com.satyam.academia/
        └── AcademiaApplicationTests # Unit and integration tests
```

---

## **Features**

### **Specialization Management**
- **Create Specialization**: Add a new specialization with details like name, description, year, etc.
- **Update Specialization**: Edit existing specialization details.
- **Delete Specialization**: Remove a specialization.
- **Get Specializations**: Retrieve all specializations.

### **Course Management**
- **Assign Courses to Specialization**: Link courses to specific specializations.
- **View Courses**: List all courses associated with a specialization.
- **Update Courses**: Modify details of courses under a specialization.
- **Delete Courses**: Remove a course from a specialization.

### **Authentication**
- **Login**: Secure login using JWT authentication.
- **Role-Based Access**: Restrict actions based on user roles (e.g., Admin, Employee).

---

## **API Endpoints**

### **Authentication**
| Method | Endpoint         | Description                |
|--------|------------------|----------------------------|
| POST   | `/api/login`     | Logs in a user and returns a JWT. |

### **Specialization Management**
| Method | Endpoint                     | Description                               |
|--------|------------------------------|-------------------------------------------|
| GET    | `/api/specializations`       | Retrieves all specializations.            |
| POST   | `/api/specializations`       | Creates a new specialization.             |
| PUT    | `/api/specializations/{id}`  | Updates an existing specialization.       |
| DELETE | `/api/specializations/{id}`  | Deletes a specialization.                 |

### **Course Management**
| Method | Endpoint                                        | Description                                     |
|--------|------------------------------------------------|-------------------------------------------------|
| GET    | `/api/specializations/{id}/courses`            | Retrieves all courses under a specialization.  |
| POST   | `/api/specializations/{id}/courses`            | Adds a course to a specialization.             |
| PUT    | `/api/specializations/{id}/courses/{courseId}` | Updates details of a specific course.          |
| DELETE | `/api/specializations/{id}/courses/{courseId}` | Deletes a course from a specialization.        |

---

## **Setup and Installation**

### **Prerequisites**
- **Java 11** or higher
- **Maven** (for dependency management)
- **MySQL** (or any other relational database)

### **Steps to Run the Application**

1. **Clone the Repository**
   ```bash
   git clone <repository_url>
   cd <repository_folder>
   ```

2. **Configure the Database**
   - Update `application.properties` with your database details:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/academia
     spring.datasource.username=<your_db_username>
     spring.datasource.password=<your_db_password>
     ```

3. **Build and Run the Application**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access the Application**
   - The application will be available at [http://localhost:8080](http://localhost:8080).

5. **Load Sample Data**
   - Sample data can be loaded from `data.sql`.

---

## **Security**
- Uses **JWT** for secure authentication.
- Passwords are encrypted using `EncryptionService`.

---

## **Testing**
- Unit and integration tests are provided in the `test` directory.
- To run tests:
  ```bash
  mvn test


