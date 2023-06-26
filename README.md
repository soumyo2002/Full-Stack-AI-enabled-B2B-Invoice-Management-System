# Full Stack AI-enabled B2B Invoice Management System

This project is a full-stack AI-enabled B2B Invoice Management System developed during my summer internship at HighRadius. It aims to develop a B2B Invoice Management System with a focus on machine learning-based prediction of future order amounts. The system operates in the B2B domain, where businesses work on credit and issue invoices for goods purchased. The objective is to assist the Credit Check Department in predicting the order amount that customers might make in the upcoming days, helping the company manage services and product supply without hampering cash inflow.

## Business Overview

The B2B world functions differently from B2C or C2C models, with businesses operating on credit. When a buyer places an order with a seller, the seller issues an invoice containing information about the goods purchased and payment details. Accounts receivable represent money owed by customers to the business on credit. The Credit Check Department validates customers, verifies credit limits, checks purchase orders, and calculates exposure for each customer to ensure a smooth order inflow process.

## Problem Statement

The project's main objective is to build a machine learning model that predicts the order amount customers are likely to place in the upcoming days. Given a dataset of past orders and customer behavior, the model should analyze patterns to forecast future order amounts accurately. The application will provide AI support for predicting order amounts and persist the predictions across sessions.

## High-Level Requirements

- Order Dataset: Parse and process the provided order dataset.
- AI Support: Implement AI-based prediction of upcoming order amounts for a specified time frame.
- User Interface: Develop a user-friendly interface with a button to trigger the prediction and display the predicted order amounts.

## Functional Overview

The project utilizes an order dataset provided by HighRadius. The dataset contains various fields such as customer order ID, sales organization, distribution channel, order amount, and more. The system parses and processes this dataset for analysis and prediction. The user interface features a Predict button, which, when clicked, triggers the prediction of order amounts for the specified time frame. The predicted order amounts are then displayed in a dedicated column.

## Features

- **Machine Learning Model**: The project includes a machine learning model trained on historical order data to accurately predict future order amounts.
- **Web Interface**: A user-friendly web interface is built to allow clients to access and interact with the AI-generated predictions.
- **Optimized Efficiency**: The system aims to optimize B2B invoice management processes by leveraging the power of machine learning and web technologies.

## Installation

To run this project locally, please follow the instructions below:

1. Clone the repository: `git clone https://github.com/soumyo2002/Full-Stack-AI-enabled-B2B-Invoice-Management-System.git`
2. Install the required dependencies:
3. Launch the web application
4. Launch JDBC for backend
5. Access the application in your web browser at localhost

## Technologies Used

- Python
- Machine Learning (ML)
- Flask
- React
- Material UI
- JavaScript
- JDBC
  

## Acknowledgements

I would like to express my gratitude to HighRadius for providing me with the opportunity to work on this project during my internship. Special thanks to my mentors for their guidance and support throughout the development process.


