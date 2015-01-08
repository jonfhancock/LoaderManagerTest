# LoaderManagerTest

This simple application is intended to illustrate how getLoaderManager() should only be called in or after onActivityCreated().

When you call getLoaderManager() from a Fragment, the LoaderManager returned [is retrieved from the parent Activity](https://android.googlesource.com/platform/frameworks/support/+/refs/heads/master/v4/java/android/support/v4/app/Fragment.java#876), given the index of the Fragment as [a variable named mWho](https://android.googlesource.com/platform/frameworks/support/+/refs/heads/master/v4/java/android/support/v4/app/Fragment.java#476).

The problem is that for some cases, the index of the Fragment is not set until onActivityCreated(), and therefore mWho is null.

Since the [toString() method](https://android.googlesource.com/platform/frameworks/support/+/refs/heads/master/v4/java/android/support/v4/app/Fragment.java#504) of a Fragment includes its index, you can see that the getLoadermanager call would be passing two different values for mWho, one null, and one populated.

This can be seen in this example by watching the logs and performing the following steps:

1. Launch the app
2. Observe that the first two fragments are created, and their indecies are correct in both onCreate and onActivityCreated.
3. Press the tab labeled "PAGE 2"
4. Observe that the index is not present in onCreate, but is present on onActivityCreated.

