# My City App – Project Plan

## Overview
"My City" is an Android application built with Jetpack Compose.  
The app allows users to explore different categories of places in the city (e.g., Parks, Restaurants, Museums) and view detailed information about each place.

The goal of this project is to demonstrate:
- Jetpack Compose UI
- Navigation between multiple screens
- Adaptive layouts
- Clean project structure

---

## Architecture Overview

The app follows a simple layered structure:

- **Data Layer**
    - `Place` data class
    - `LocalDataSource` providing static city data

- **UI Layer**
    - `HomeScreen` – displays categories
    - `CategoryScreen` – displays list of places
    - `DetailScreen` – displays detailed information

- **Navigation**
    - `AppNavGraph`
    - Navigation using `NavHostController`

---

## Main Features

### 1. Category List (Home Screen)
- Displays city categories in adaptive grid
- Uses `LazyVerticalGrid`
- Responsive layout

### 2. Places List (Category Screen)
- Shows places by selected category
- Image cards with overlay text
- Back button navigation

### 3. Detail Screen
- Displays:
    - Large image
    - Place name
    - Description
    - "Open in Maps" button
- Adaptive layout:
    - Phone → Vertical layout
    - Tablet → Horizontal layout

---

## Adaptive Design

The app supports different screen sizes.

- Uses `GridCells.Adaptive`
- Uses `LocalConfiguration` to detect screen width
- Adjusts layout for tablets (≥700dp)

---

## Technologies Used

- Kotlin
- Jetpack Compose
- Material 3
- Navigation Compose
- Adaptive UI techniques

---

## Future Improvements

- Add Favorites feature
- Add ViewModel + State management
- Connect to real API instead of static data
- Add animations between screens
- Improve UI polish

---

## Conclusion

This project demonstrates:
- Multi-screen navigation
- Adaptive design
- Modern Android development using Jetpack Compose
- Clean UI structure

The application is stable and fully functional.