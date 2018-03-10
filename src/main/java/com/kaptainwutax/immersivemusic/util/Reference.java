package com.kaptainwutax.immersivemusic.util;

public class Reference {
	
	public static final String MOD_ID = "kwimm";
	public static final String NAME = "Immersive Music";
	public static final String VERSION = "Alpha";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	
	public static final String CLIENT_PROXY_CLASS = "com.kaptainwutax.immersivemusic.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.kaptainwutax.immersivemusic.proxy.ServerProxy";
	
	public static enum ImmersiveMusicBlocks {
		
		MUSICBLOCK("music_block", "music_block");
		
		private String unlocalizedName;
		private String registryName;
		
		ImmersiveMusicBlocks(String unlocalizedName, String registryName) {
			
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			
			return unlocalizedName;
		}
		
		public String getRegistryName() {
			
			return registryName;
		}
	}
}