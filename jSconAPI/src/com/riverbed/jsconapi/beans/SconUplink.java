package com.riverbed.jsconapi.beans;

public class SconUplink extends SconObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7796531156047953500L;
	
	public static final String TYPE_DHCP = "dhcpc";
	public static final String TYPE_STATIC = "static";
	public static final String TYPE_DLS_PPOOE = "pppoe";
	public static final String TYPE_DLS_PPPOA_PPtP = "pptp";
	
	private int qos_bw_up;
	private int qos_up;
	private int qos_bw_down;
	private int qos_down;
	private String site;
	private String static_gw_v6;
	private String static_ip_v6;
	private String static_gw_v4;
	
	//ip_v4 should be in the following format :x.x.x.x/yy where yy is the netmask 
	private String static_ip_v4;
	private int uin;
	private String node;
	private String wan;            
	private String port; 
	private int vlan;
	private String type;
	private boolean backup;
	private String sitelink_ipsel;
	private String sitelink_custom_ip;
	private String sitelink_prio;
	private String bgp_advertised_routes;
	private String bgp_learned_routes_ver2;
	private String bgp_advertised_routes_ver2;
	private int bgp_enable ;
	private String bgp_router_id;
	private String bgp_local_as;
	private String bgp_neigh_name;
	private String bgp_neigh_remote_as;
	private String bgp_neigh_ipv4;
	private String bgp_neigh_password;
	private int bgp_neigh_keepalive_time;
	private int bgp_neigh_hold_time;
	private int mtu;
	private String qos_inbound;
	private String qos_inbound_Bandwidth;
	private String qos_inbound_units;
	private String qos_outbound ;
	private String qos_outbound_Bandwidth;
	private String qos_outbound_units;
	private boolean auto_negotiation;
	private int link_speed;
	private String PPP_reconnect;
	private int dead_interval;
	private int cost;
	
	public int getQos_bw_up() {
		return qos_bw_up;
	}
	public void setQos_bw_up(int qos_bw_up) {
		this.qos_bw_up = qos_bw_up;
	}
	public int getQos_up() {
		return qos_up;
	}
	public void setQos_up(int qos_up) {
		this.qos_up = qos_up;
	}
	public int getQos_bw_down() {
		return qos_bw_down;
	}
	public void setQos_bw_down(int qos_bw_down) {
		this.qos_bw_down = qos_bw_down;
	}
	public int getQos_down() {
		return qos_down;
	}
	public void setQos_down(int qos_down) {
		this.qos_down = qos_down;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getStatic_gw_v6() {
		return static_gw_v6;
	}
	public void setStatic_gw_v6(String static_gw_v6) {
		this.static_gw_v6 = static_gw_v6;
	}
	public String getStatic_ip_v6() {
		return static_ip_v6;
	}
	public void setStatic_ip_v6(String static_ip_v6) {
		this.static_ip_v6 = static_ip_v6;
	}
	public String getStatic_gw_v4() {
		return static_gw_v4;
	}
	public void setStatic_gw_v4(String static_gw_v4) {
		this.static_gw_v4 = static_gw_v4;
	}
	public String getStatic_ip_v4() {
		return static_ip_v4;
	}
	public void setStatic_ip_v4(String static_ip_v4) {
		this.static_ip_v4 = static_ip_v4;
	}
	public int getUin() {
		return uin;
	}
	public void setUin(int uin) {
		this.uin = uin;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getWan() {
		return wan;
	}
	public void setWan(String wan) {
		this.wan = wan;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public int getVlan() {
		return vlan;
	}
	public void setVlan(int vlan) {
		this.vlan = vlan;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public SconUplink(String name,String site, String wan) {
		super();
		this.site = site;
		this.wan = wan;
		this.setName(name);
		this.qos_bw_up = 0;
		this.qos_up = 0;
		this.qos_bw_down = 0;
		this.qos_down = 0;
		this.static_gw_v6 = "";
		this.static_ip_v6 = "";
		this.static_gw_v4 = "";
		this.static_ip_v4 = "";
		this.node = "";
		this.port = "";
		this.vlan = 0;
		this.type = "dhcpc";
	}
	/**
	 * @param qos_bw_up
	 * @param qos_up
	 * @param qos_bw_down
	 * @param qos_down
	 * @param site
	 * @param static_gw_v6
	 * @param static_ip_v6
	 * @param static_gw_v4
	 * @param static_ip_v4
	 * @param node
	 * @param wan
	 * @param port
	 * @param vlan
	 * @param type
	 */
	public SconUplink(String id, String name,int qos_bw_up, int qos_up, int qos_bw_down, int qos_down, String site, String static_gw_v6,
			String static_ip_v6, String static_gw_v4, String static_ip_v4, String node, String wan, String port,
			int vlan, String type) {
		super();
		this.setId(id);
		this.setName(name);
		this.qos_bw_up = qos_bw_up;
		this.qos_up = qos_up;
		this.qos_bw_down = qos_bw_down;
		this.qos_down = qos_down;
		this.site = site;
		this.static_gw_v6 = static_gw_v6;
		this.static_ip_v6 = static_ip_v6;
		this.static_gw_v4 = static_gw_v4;
		this.static_ip_v4 = static_ip_v4;
		this.node = node;
		this.wan = wan;
		this.port = port;
		this.vlan = vlan;
		this.type = type;
	}
	
	public SconUplink(String id, String name,int qos_bw_up, int qos_up, int qos_bw_down, int qos_down, String site, String static_gw_v6,
			String static_ip_v6, String static_gw_v4, String static_ip_v4, String node, String wan, String port,
			int vlan, String type, boolean auto_negotiation, int link_speed) {
		super();
		this.setId(id);
		this.setName(name);
		this.qos_bw_up = qos_bw_up;
		this.qos_up = qos_up;
		this.qos_bw_down = qos_bw_down;
		this.qos_down = qos_down;
		this.site = site;
		this.static_gw_v6 = static_gw_v6;
		this.static_ip_v6 = static_ip_v6;
		this.static_gw_v4 = static_gw_v4;
		this.static_ip_v4 = static_ip_v4;
		this.node = node;
		this.wan = wan;
		this.port = port;
		this.vlan = vlan;
		this.type = type;
		this.auto_negotiation = auto_negotiation;
		this.link_speed = link_speed;
	}
	
	public SconUplink( String name, String site, String static_gw_v6,
			String static_ip_v6, String static_gw_v4, String static_ip_v4, String wan, String port,
			int vlan, String type, boolean auto_negotiation, int link_speed) {
		super();
		this.setName(name);
		this.site = site;
		this.static_gw_v6 = static_gw_v6;
		this.static_ip_v6 = static_ip_v6;
		this.static_gw_v4 = static_gw_v4;
		this.static_ip_v4 = static_ip_v4;
		this.wan = wan;
		this.port = port;
		this.vlan = vlan;
		this.type = type;
		this.auto_negotiation = auto_negotiation;
		this.link_speed = link_speed;
	}
	/**
	 * @return the backup
	 */
	public boolean isBackup() {
		return backup;
	}
	/**
	 * @param backup the backup to set
	 */
	public void setBackup(boolean backup) {
		this.backup = backup;
	}
	/**
	 * @return the sitelink_ipsel
	 */
	public String getSitelink_ipsel() {
		return sitelink_ipsel;
	}
	/**
	 * @param sitelink_ipsel the sitelink_ipsel to set
	 */
	public void setSitelink_ipsel(String sitelink_ipsel) {
		this.sitelink_ipsel = sitelink_ipsel;
	}
	/**
	 * @return the sitelink_custom_ip
	 */
	public String getSitelink_custom_ip() {
		return sitelink_custom_ip;
	}
	/**
	 * @param sitelink_custom_ip the sitelink_custom_ip to set
	 */
	public void setSitelink_custom_ip(String sitelink_custom_ip) {
		this.sitelink_custom_ip = sitelink_custom_ip;
	}
	/**
	 * @return the sitelink_prio
	 */
	public String getSitelink_prio() {
		return sitelink_prio;
	}
	/**
	 * @param sitelink_prio the sitelink_prio to set
	 */
	public void setSitelink_prio(String sitelink_prio) {
		this.sitelink_prio = sitelink_prio;
	}
	/**
	 * @return the bgp_advertised_routes
	 */
	public String getBgp_advertised_routes() {
		return bgp_advertised_routes;
	}
	/**
	 * @param bgp_advertised_routes the bgp_advertised_routes to set
	 */
	public void setBgp_advertised_routes(String bgp_advertised_routes) {
		this.bgp_advertised_routes = bgp_advertised_routes;
	}
	/**
	 * @return the bgp_learned_routes_ver2
	 */
	public String getBgp_learned_routes_ver2() {
		return bgp_learned_routes_ver2;
	}
	/**
	 * @param bgp_learned_routes_ver2 the bgp_learned_routes_ver2 to set
	 */
	public void setBgp_learned_routes_ver2(String bgp_learned_routes_ver2) {
		this.bgp_learned_routes_ver2 = bgp_learned_routes_ver2;
	}
	/**
	 * @return the bgp_advertised_routes_ver2
	 */
	public String getBgp_advertised_routes_ver2() {
		return bgp_advertised_routes_ver2;
	}
	/**
	 * @param bgp_advertised_routes_ver2 the bgp_advertised_routes_ver2 to set
	 */
	public void setBgp_advertised_routes_ver2(String bgp_advertised_routes_ver2) {
		this.bgp_advertised_routes_ver2 = bgp_advertised_routes_ver2;
	}
	/**
	 * @return the bgp_enable
	 */
	public int getBgp_enable() {
		return bgp_enable;
	}
	/**
	 * @param bgp_enable the bgp_enable to set
	 */
	public void setBgp_enable(int bgp_enable) {
		this.bgp_enable = bgp_enable;
	}
	/**
	 * @return the bgp_router_id
	 */
	public String getBgp_router_id() {
		return bgp_router_id;
	}
	/**
	 * @param bgp_router_id the bgp_router_id to set
	 */
	public void setBgp_router_id(String bgp_router_id) {
		this.bgp_router_id = bgp_router_id;
	}
	/**
	 * @return the bgp_local_as
	 */
	public String getBgp_local_as() {
		return bgp_local_as;
	}
	/**
	 * @param bgp_local_as the bgp_local_as to set
	 */
	public void setBgp_local_as(String bgp_local_as) {
		this.bgp_local_as = bgp_local_as;
	}
	/**
	 * @return the bgp_neigh_name
	 */
	public String getBgp_neigh_name() {
		return bgp_neigh_name;
	}
	/**
	 * @param bgp_neigh_name the bgp_neigh_name to set
	 */
	public void setBgp_neigh_name(String bgp_neigh_name) {
		this.bgp_neigh_name = bgp_neigh_name;
	}
	/**
	 * @return the bgp_neigh_remote_as
	 */
	public String getBgp_neigh_remote_as() {
		return bgp_neigh_remote_as;
	}
	/**
	 * @param bgp_neigh_remote_as the bgp_neigh_remote_as to set
	 */
	public void setBgp_neigh_remote_as(String bgp_neigh_remote_as) {
		this.bgp_neigh_remote_as = bgp_neigh_remote_as;
	}
	/**
	 * @return the bgp_neigh_ipv4
	 */
	public String getBgp_neigh_ipv4() {
		return bgp_neigh_ipv4;
	}
	/**
	 * @param bgp_neigh_ipv4 the bgp_neigh_ipv4 to set
	 */
	public void setBgp_neigh_ipv4(String bgp_neigh_ipv4) {
		this.bgp_neigh_ipv4 = bgp_neigh_ipv4;
	}
	/**
	 * @return the bgp_neigh_password
	 */
	public String getBgp_neigh_password() {
		return bgp_neigh_password;
	}
	/**
	 * @param bgp_neigh_password the bgp_neigh_password to set
	 */
	public void setBgp_neigh_password(String bgp_neigh_password) {
		this.bgp_neigh_password = bgp_neigh_password;
	}
	/**
	 * @return the bgp_neigh_keepalive_time
	 */
	public int getBgp_neigh_keepalive_time() {
		return bgp_neigh_keepalive_time;
	}
	/**
	 * @param bgp_neigh_keepalive_time the bgp_neigh_keepalive_time to set
	 */
	public void setBgp_neigh_keepalive_time(int bgp_neigh_keepalive_time) {
		this.bgp_neigh_keepalive_time = bgp_neigh_keepalive_time;
	}
	/**
	 * @return the bgp_neigh_hold_time
	 */
	public int getBgp_neigh_hold_time() {
		return bgp_neigh_hold_time;
	}
	/**
	 * @param bgp_neigh_hold_time the bgp_neigh_hold_time to set
	 */
	public void setBgp_neigh_hold_time(int bgp_neigh_hold_time) {
		this.bgp_neigh_hold_time = bgp_neigh_hold_time;
	}
	/**
	 * @return the mtu
	 */
	public int getMtu() {
		return mtu;
	}
	/**
	 * @param mtu the mtu to set
	 */
	public void setMtu(int mtu) {
		this.mtu = mtu;
	}
	/**
	 * @return the qos_inbound
	 */
	public String getQos_inbound() {
		return qos_inbound;
	}
	/**
	 * @param qos_inbound the qos_inbound to set
	 */
	public void setQos_inbound(String qos_inbound) {
		this.qos_inbound = qos_inbound;
	}
	/**
	 * @return the qos_inbound_Bandwidth
	 */
	public String getQos_inbound_Bandwidth() {
		return qos_inbound_Bandwidth;
	}
	/**
	 * @param qos_inbound_Bandwidth the qos_inbound_Bandwidth to set
	 */
	public void setQos_inbound_Bandwidth(String qos_inbound_Bandwidth) {
		this.qos_inbound_Bandwidth = qos_inbound_Bandwidth;
	}
	/**
	 * @return the qos_inbound_units
	 */
	public String getQos_inbound_units() {
		return qos_inbound_units;
	}
	/**
	 * @param qos_inbound_units the qos_inbound_units to set
	 */
	public void setQos_inbound_units(String qos_inbound_units) {
		this.qos_inbound_units = qos_inbound_units;
	}
	/**
	 * @return the qos_outbound
	 */
	public String getQos_outbound() {
		return qos_outbound;
	}
	/**
	 * @param qos_outbound the qos_outbound to set
	 */
	public void setQos_outbound(String qos_outbound) {
		this.qos_outbound = qos_outbound;
	}
	/**
	 * @return the qos_outbound_Bandwidth
	 */
	public String getQos_outbound_Bandwidth() {
		return qos_outbound_Bandwidth;
	}
	/**
	 * @param qos_outbound_Bandwidth the qos_outbound_Bandwidth to set
	 */
	public void setQos_outbound_Bandwidth(String qos_outbound_Bandwidth) {
		this.qos_outbound_Bandwidth = qos_outbound_Bandwidth;
	}
	/**
	 * @return the qos_outbound_units
	 */
	public String getQos_outbound_units() {
		return qos_outbound_units;
	}
	/**
	 * @param qos_outbound_units the qos_outbound_units to set
	 */
	public void setQos_outbound_units(String qos_outbound_units) {
		this.qos_outbound_units = qos_outbound_units;
	}
	/**
	 * @return the auto_negotiation
	 */
	public boolean isAuto_negotiation() {
		return auto_negotiation;
	}
	/**
	 * @param auto_negotiation the auto_negotiation to set
	 */
	public void setAuto_negotiation(boolean auto_negotiation) {
		this.auto_negotiation = auto_negotiation;
	}
	/**
	 * @return the link_speed
	 */
	public int getLink_speed() {
		return link_speed;
	}
	/**
	 * @param link_speed the link_speed to set
	 */
	public void setLink_speed(int link_speed) {
		this.link_speed = link_speed;
	}
	/**
	 * @return the pPP_reconnect
	 */
	public String getPPP_reconnect() {
		return PPP_reconnect;
	}
	/**
	 * @param pPP_reconnect the pPP_reconnect to set
	 */
	public void setPPP_reconnect(String pPP_reconnect) {
		PPP_reconnect = pPP_reconnect;
	}
	/**
	 * @return the dead_interval
	 */
	public int getDead_interval() {
		return dead_interval;
	}
	/**
	 * @param dead_interval the dead_interval to set
	 */
	public void setDead_interval(int dead_interval) {
		this.dead_interval = dead_interval;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * @return
	 */
	@Override
	public String toString() {
		return "SconUplink [qos_bw_up=" + qos_bw_up + ", qos_up=" + qos_up + ", qos_bw_down=" + qos_bw_down
				+ ", qos_down=" + qos_down + ", site=" + site + ", static_gw_v6=" + static_gw_v6 + ", static_ip_v6="
				+ static_ip_v6 + ", static_gw_v4=" + static_gw_v4 + ", static_ip_v4=" + static_ip_v4 + ", uin=" + uin
				+ ", node=" + node + ", wan=" + wan + ", port=" + port + ", vlan=" + vlan + ", type=" + type
				+ ", backup=" + backup + ", sitelink_ipsel=" + sitelink_ipsel + ", sitelink_custom_ip="
				+ sitelink_custom_ip + ", sitelink_prio=" + sitelink_prio + ", bgp_advertised_routes="
				+ bgp_advertised_routes + ", bgp_learned_routes_ver2=" + bgp_learned_routes_ver2
				+ ", bgp_advertised_routes_ver2=" + bgp_advertised_routes_ver2 + ", bgp_enable=" + bgp_enable
				+ ", bgp_router_id=" + bgp_router_id + ", bgp_local_as=" + bgp_local_as + ", bgp_neigh_name="
				+ bgp_neigh_name + ", bgp_neigh_remote_as=" + bgp_neigh_remote_as + ", bgp_neigh_ipv4=" + bgp_neigh_ipv4
				+ ", bgp_neigh_password=" + bgp_neigh_password + ", bgp_neigh_keepalive_time="
				+ bgp_neigh_keepalive_time + ", bgp_neigh_hold_time=" + bgp_neigh_hold_time + ", mtu=" + mtu
				+ ", qos_inbound=" + qos_inbound + ", qos_inbound_Bandwidth=" + qos_inbound_Bandwidth
				+ ", qos_inbound_units=" + qos_inbound_units + ", qos_outbound=" + qos_outbound
				+ ", qos_outbound_Bandwidth=" + qos_outbound_Bandwidth + ", qos_outbound_units=" + qos_outbound_units
				+ ", auto_negotiation=" + auto_negotiation + ", link_speed=" + link_speed + ", PPP_reconnect="
				+ PPP_reconnect + ", dead_interval=" + dead_interval + ", cost=" + cost + "]";
	}
	
	

}
