package phones;


public enum Phones {
	//          DeviceName    			 platform     DeviceUdid                                  OSVersion
    MY_NEXUS_4 ("MyNexus4",	   			"android",   "022aa82da1cad7c0", 	                     "5.0.1"),
	HTC_ONE    ("Htc one",              "android",   "HT358W920160",                             "4.4.3"),
	GT_I9192   ("SamsungS4Mini dous",	"android",   "0066c9b9",                                 "4.2.2"),
    GT_I9300   ("SamsungS3",            "android",   "4df1289350f45ff7",                         "4.3"),
    GT_I7100   ("Samsung Note 2",       "android",   "4df71ff93b75cfdf",                         "4.4.2"),
    IPHONE6    ("Iphone6",              "iOS",       "acd3fc64cc481ed9d51ced3beb9a19d3f1c7858b", "8.1.3"),

    IPHONE5S   ("Iphone5s",             "iOS",       "b4ffb335431dc8c6986e65c224b75ec7514247c0", "8.1.3");

	private final String deviceName;
	private final String platform;
	private final String udid;
	private final String androidVersion;

	Phones (String deviceName, String platform, String udid, String androidVersion){
		this.deviceName = deviceName; 
		this.platform = platform; 
		this.udid= udid; 
		this.androidVersion=androidVersion;

	}


	public String getDeviceName() {
		return this.deviceName;
	}

	public String getPlatform() {
		return this.platform;
	}

	public String getUdid() {
		return this.udid;
	}

	public String getAndroidVersion() {
		return this.androidVersion;
	}


}
