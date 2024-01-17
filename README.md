
<h1 align="center">TopSnackBar</h1>
<h3 align="center">A general implementation of a Top Snackbar.</h3>

Steps to configure it in your project:

Add this to your <b>settings.gradle</b>

```kotlin
repositories {
  mavenCentral()
  maven { url 'https://jitpack.io' }
}
```

Add the following dependency to the application's gradle:

```kotlin
dependencies {
  implementation 'com.github.khizzar:TopSnackBar:Tag'
}
```
Replace "Tag" with the latest release version provided.

To use the Top Snackbar in you application use the object provided and setup the top snackbar and setup the required properties as follwowing:

```kotlin
TopSnackBar.makeSnackBar(SnackBarDataModel(
  rootView = view, // the root view
  displayMsg = "Message", // message to be shown 
  bgColorID = getColor(android.R.color.black), // color code reference
  txtColorID = getColor(android.R.color.white), // color code reference
  displayIconID = R.drawable.status_ok, // left drawable for the top snackbar
  actionBtnSetup = ActionBtnSetup( // this model contains the action btn setup along with the action to be performed
      showActionButton = true, // show the action button
      actionBtnText = "Action", // define the text of the button
      btnBgColor = getColor(android.R.color.holo_blue_bright), // color reference code for button's background
      textColor = getColor(android.R.color.white), // color reference code for text color of the button
      action = { // action to be performed
          Toast.makeText(this, "Working", Toast.LENGTH_LONG).show()
      }
    )
))
```

That is it simple and steady :)

