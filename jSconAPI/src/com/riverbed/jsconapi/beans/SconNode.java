package com.riverbed.jsconapi.beans;


public class SconNode extends SconObject{
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = -1271754552868175679L;
		public static final String SDI_VGW = "yogi"; 	
	 	public static final String SDI_AWS = "booboo";	
	 	public static final String SDI_SH = "baloo";		
	 	public static final String SDI_USB  = "fozzy"; 		
	 	public static final String SDI_AP3 = "raccoon"; 	
	 	public static final String SDI_AP5 = "koala";
	 	public static final String SDI_AP5r = "ursus";	
	 	public static final String SDI_130 = "panda"; 	
	 	public static final String SDI_330 = "ewok"; 	
	 	public static final String SDI_1030 = "grizzly"; 	
	 	public static final String SDI_S12 = "aardvark";
	 	public static final String SDI_S24 = "sloth";
	 	public static final String SDI_S48 = "kodiak";
	 	public static final String CX_570 = "cx570";
	 	public static final String CX_770 = "cx770";
	 	public static final String CX_3070 = "cx3070"; 		
	 	public static final String Tiger = "tiger"; 		
	 	public static final String SDI_5030 = "panther"; 

	 	private String[] uplinks;
	 	private String localAS;
	 	private String model;
	 	private String[] radios;
	 	private boolean simulated;
	 	private String routerId;
	 	private boolean disableStp;
	 	private String location;
	 	private String serial;
	 	private String license;
	 	private String inventoryVersionCC;
	 	private String[] ports;
	 	private String site;
	 	private boolean sitelink;
	 	private String haMgmtIP;
	 	private String haPartner;
	 	private String haDedicatedPort;
	 	private String haControlLink;
	 	private boolean scm_managed_vsh;
	 	private boolean ha_clone_mac;
         
    	
		/**
		 * @return the uplinks
		 */
		public String[] getUplinks() {
			return uplinks;
		}
		/**
		 * @param uplinks the uplinks to set
		 */
		public void setUplinks(String[] uplinks) {
			this.uplinks = uplinks;
		}
		/**
		 * @return the localAS
		 */
		public String getLocalAS() {
			return localAS;
		}
		/**
		 * @param localAS the localAS to set
		 */
		public void setLocalAS(String localAS) {
			this.localAS = localAS;
		}
		/**
		 * @return the model
		 */
		public String getModel() {
			return model;
		}
		/**
		 * @param model the model to set
		 */
		public void setModel(String model) {
			this.model = model;
		}
		/**
		 * @return the radios
		 */
		public String[] getRadios() {
			return radios;
		}
		/**
		 * @param radios the radios to set
		 */
		public void setRadios(String[] radios) {
			this.radios = radios;
		}
		/**
		 * @return the simulated
		 */
		
		/**
		 * @return the routerId
		 */
		public String getRouterId() {
			return routerId;
		}
		/**
		 * @return the simulated
		 */
		public boolean isSimulated() {
			return simulated;
		}
		/**
		 * @param simulated the simulated to set
		 */
		public void setSimulated(boolean simulated) {
			this.simulated = simulated;
		}
		/**
		 * @param routerId the routerId to set
		 */
		public void setRouterId(String routerId) {
			this.routerId = routerId;
		}
		/**
		 * @return the disableStp
		 */
		
		/**
		 * @return the location
		 */
		public String getLocation() {
			return location;
		}
		/**
		 * @return the disableStp
		 */
		public boolean isDisableStp() {
			return disableStp;
		}
		/**
		 * @param disableStp the disableStp to set
		 */
		public void setDisableStp(boolean disableStp) {
			this.disableStp = disableStp;
		}
		/**
		 * @param location the location to set
		 */
		public void setLocation(String location) {
			this.location = location;
		}
		/**
		 * @return the serial
		 */
		public String getSerial() {
			return serial;
		}
		/**
		 * @param serial the serial to set
		 */
		public void setSerial(String serial) {
			this.serial = serial;
		}
		/**
		 * @return the license
		 */
		public String getLicense() {
			return license;
		}
		/**
		 * @param license the license to set
		 */
		public void setLicense(String license) {
			this.license = license;
		}
		/**
		 * @return the inventoryVersionCC
		 */
		public String getInventoryVersionCC() {
			return inventoryVersionCC;
		}
		/**
		 * @param inventoryVersionCC the inventoryVersionCC to set
		 */
		public void setInventoryVersionCC(String inventoryVersionCC) {
			this.inventoryVersionCC = inventoryVersionCC;
		}
		/**
		 * @return the ports
		 */
		public String[] getPorts() {
			return ports;
		}
		/**
		 * @param ports the ports to set
		 */
		public void setPorts(String[] ports) {
			this.ports = ports;
		}
		/**
		 * @return the site
		 */
		public String getSite() {
			return site;
		}
		/**
		 * @param site the site to set
		 */
		public void setSite(String site) {
			this.site = site;
		}
		
		
		
		/**
		 * @return the sitelink
		 */
		public boolean isSitelink() {
			return sitelink;
		}
		/**
		 * @param sitelink the sitelink to set
		 */
		public void setSitelink(boolean sitelink) {
			this.sitelink = sitelink;
		}
		/**
		 * 
		 * @param name
		 * @param model
		 * @param simulated
		 * @param site
		 */
		public SconNode(String name,String model, boolean simulated, String site,String serial) {
			super();
			this.setName(name);
			this.model = model;
			this.simulated = simulated;
			this.site = site;
			this.serial = serial;
		}
		/**
		 * 
		 * @param name
		 * @param id
		 * @param uplinks
		 * @param model
		 * @param simulated
		 * @param ports
		 * @param site
		 */
		
		public SconNode(String id,String[] uplinks, String model, boolean simulated, String[] ports, String site) {
			super();
			this.setId(id);
			this.uplinks = uplinks;
			this.model = model;
			this.simulated = simulated;
			this.ports = ports;
			this.site = site;
		}
		
		
		
		/**
		 * @return the haMgmtIP
		 */
		public String getHaMgmtIP() {
			return haMgmtIP;
		}
		/**
		 * @param haMgmtIP the haMgmtIP to set
		 */
		public void setHaMgmtIP(String haMgmtIP) {
			this.haMgmtIP = haMgmtIP;
		}
		/**
		 * @return the haPartner
		 */
		public String getHaPartner() {
			return haPartner;
		}
		/**
		 * @param haPartner the haPartner to set
		 */
		public void setHaPartner(String haPartner) {
			this.haPartner = haPartner;
		}
		/**
		 * @return the haDedicatedPort
		 */
		public String getHaDedicatedPort() {
			return haDedicatedPort;
		}
		/**
		 * @param haDedicatedPort the haDedicatedPort to set
		 */
		public void setHaDedicatedPort(String haDedicatedPort) {
			this.haDedicatedPort = haDedicatedPort;
		}
		/**
		 * @return the haControlLink
		 */
		public String getHaControlLink() {
			return haControlLink;
		}
		/**
		 * @param haControlLink the haControlLink to set
		 */
		public void setHaControlLink(String haControlLink) {
			this.haControlLink = haControlLink;
		}
		/**
		 * @return the scm_managed_vsh
		 */
		public boolean isScm_managed_vsh() {
			return scm_managed_vsh;
		}
		/**
		 * @param scm_managed_vsh the scm_managed_vsh to set
		 */
		public void setScm_managed_vsh(boolean scm_managed_vsh) {
			this.scm_managed_vsh = scm_managed_vsh;
		}
		/**
		 * @return the ha_clone_mac
		 */
		public boolean isHa_clone_mac() {
			return ha_clone_mac;
		}
		/**
		 * @param ha_clone_mac the ha_clone_mac to set
		 */
		public void setHa_clone_mac(boolean ha_clone_mac) {
			this.ha_clone_mac = ha_clone_mac;
		}
		
		
		/**
		 * @param uplinks
		 * @param localAS
		 * @param model
		 * @param radios
		 * @param simulated
		 * @param routerId
		 * @param disableStp
		 * @param location
		 * @param serial
		 * @param license
		 * @param inventoryVersionCC
		 * @param ports
		 * @param site
		 * @param sitelink
		 * @param haMgmtIP
		 * @param haPartner
		 * @param haDedicatedPort
		 * @param haControlLink
		 * @param scm_managed_vsh
		 * @param ha_clone_mac
		 */
		public SconNode(String[] uplinks, String localAS, String model, String[] radios, boolean simulated,
				String routerId, boolean disableStp, String location, String serial, String license,
				String inventoryVersionCC, String[] ports, String site, boolean sitelink, String haMgmtIP,
				String haPartner, String haDedicatedPort, String haControlLink, boolean scm_managed_vsh,
				boolean ha_clone_mac) {
			super();
			this.uplinks = uplinks;
			this.localAS = localAS;
			this.model = model;
			this.radios = radios;
			this.simulated = simulated;
			this.routerId = routerId;
			this.disableStp = disableStp;
			this.location = location;
			this.serial = serial;
			this.license = license;
			this.inventoryVersionCC = inventoryVersionCC;
			this.ports = ports;
			this.site = site;
			this.sitelink = sitelink;
			this.haMgmtIP = haMgmtIP;
			this.haPartner = haPartner;
			this.haDedicatedPort = haDedicatedPort;
			this.haControlLink = haControlLink;
			this.scm_managed_vsh = scm_managed_vsh;
			this.ha_clone_mac = ha_clone_mac;
		}
		/**
		 * 
		 */
		public SconNode() {
			super();
		}
		
		
}
