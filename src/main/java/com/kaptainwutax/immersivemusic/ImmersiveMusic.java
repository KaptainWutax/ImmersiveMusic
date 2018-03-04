package com.kaptainwutax.immersivemusic;

import com.kaptainwutax.immersivemusic.proxy.CommonProxy;
import com.kaptainwutax.immersivemusic.util.Reference;
import com.kaptainwutax.immersivemusic.util.handlers.NoteBlockSoundsHandler;
import com.kaptainwutax.immersivemusic.util.handlers.RegistryHandler;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)

public class ImmersiveMusic {
	
	@Instance
	public static ImmersiveMusic instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init (FMLInitializationEvent event) {

		RegistryHandler.initRegistries();
		
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
		
	}
	
}
