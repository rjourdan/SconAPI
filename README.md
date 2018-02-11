# jSconAPI
Java API for Riverbed SteelConnect

Implementation is partial and will evolve over time. It supports other projects such as https://github.com/rjourdan/SConASK. 
Those projects are prototypes to highlight the power of network automation and in particular with Riverbed SteelConnect. Not meant to become official products.

Reference for the current Steelconnect API is https://support.riverbed.com/apis/scm_beta/scm-2.9.0/scm.config/index.html#!/zone/post_org_orgid_zones

Feel free to fork and enhance the current implementation.

Should you want to add a dependency to your project via Maven, you can use jitpack.io and add the below

Add repository first
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
Add dependency
<dependency>
    <groupId>com.github.rjourdan</groupId>
    <artifactId>SconAPI</artifactId>
    <version>1.0</version>
</dependency>
