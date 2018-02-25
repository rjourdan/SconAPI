# jSconAPI
Java API for Riverbed SteelConnect

Implementation is partial and will evolve over time. It supports other projects such as https://github.com/rjourdan/SConASK. 
Those projects are prototypes to highlight the power of network automation and in particular with Riverbed SteelConnect. Not meant to become official products.

Reference for the current Steelconnect API is https://support.riverbed.com/apis/scm_beta/scm-2.9.0/scm.config/index.html

Feel free to fork and enhance the current implementation.

Should you want to add a dependency to your project via Maven, you can use jitpack.io and add the below

Add repository first
<code><p>
&lt;repository&gt;<p>
    &lt;id&gt;jitpack.io&lt;/id&gt;<p>
    &lt;url&gt;https://jitpack.io &lt;/url&gt;<p>
&lt;/repository&gt;<p>
</code>
<p>
Then dd dependency
<code>
<p>&lt;dependency&gt;
   <p> &lt;groupId&gt;com.github.rjourdan&lt;/groupId&gt;
    <p>&lt;artifactId&gt;SconAPI&lt;/artifactId&gt;
    <p>&lt;version&gt;1.0&lt;/version&gt;
<p>&lt;/dependency&gt;
</code>
