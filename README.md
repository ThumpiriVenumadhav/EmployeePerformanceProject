
#  Employee Performance Management System 

## ** Overview**
The **Employee Performance Management System** is a full-stack web application that enables organizations to manage employees and track their performance efficiently. It provides features like **adding employees, assigning performance ratings, generating reports, and visualizing data using a Bell Curve chart**.

---

## ** Features**
 **Add Employees**      Register new employees in the system.  
 **Assign Performance Ratings**   Store ratings in the `appraisal` table.  
 **Edit & Delete Employees**   Modify or remove employee records.  
 **View Performance Report**    Display rating distribution (A-E).  
 **Generate Bell Curve Chart**   Visual representation of employee performance.  
 **Database Caching & Messaging**   Improves performance and communication.  

---


### ** Backend (Spring Boot) **
- **Spring Boot 3**    REST API for managing employees & performance.
- **Hibernate (JPA)**  ORM for database interaction.
- **MySQL**    Stores employee & appraisal data.
- **Spring Security**   Authentication & authorization.
- **RabbitMQ**   Message Queue for event-driven architecture.
- **Caching** Enhances performance.

### ** Frontend (React)**
- **React.js**  Modern UI framework.
- **React Bootstrap**  Responsive styling.
- **Axios**  API communication.
- **Chart.js**  Data visualization (Bell Curve).
- **React Router**  Navigation & routing.

---

## ** Installation & Setup**


### ** Clone the Repository**
```sh
git clone https://github.com/your-username/EmployeePerformanceProject.git
cd EmployeePerformanceProject
cd backend
mvn spring-boot:run
cd frontend
npm install




### ** Project Structure  **

EmployeePerformanceProject/
│── backend/               # Spring Boot Backend
│   ├── src/main/java/com/estuate/employeeperformance/
│   │   ├── controller/    # API Controllers
│   │   ├── service/       # Business Logic
│   │   ├── repository/    # Database Interactions
│   │   ├── entity/        # Database Models
│── frontend/              # React Frontend
│   ├── src/components/    # UI Components
│   │   ├── EmployeeList.js
│   │   ├── AddEmployee.js
│   │   ├── PerformanceReport.js
│   │   ├── BellCurveChart.js
│── README.md              # Project Documentation
│── package.json           # Frontend Dependencies
│── pom.xml                # Backend Dependencies
































# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
