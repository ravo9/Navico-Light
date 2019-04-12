# Navico-Light
A technical task given by Navico

The app architecture is based on the MVVM Design Pattern.

The central part of data flow is Contributors Data Repository that has 2 main tasks. First is to fetch data from the Back-End (it's performed using separate ApiService), and make it accessible for particular viewmodel.

ApiService consists of ApiClient (which is the final gate of this Front-End application) and ApiUtils class (being its interface). This part uses Retrofit2 library to perform communication with server.

Flow of data given by server is operated by RxJava (Reactive Java) observables, that allows to manage data streams given by few separate end-points simultaneously, and its potential error states.

GSON library is used for de-serializing data flowing from the Back-End.

Unit Testing part consists of simple Local Unit Test (performed for Contributor data model) - and is in progress.

Alpha Testing has been separated from coding phase, and performed by developer on physical device.
