
package com.flyingperson.eca;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;

@Mod(modid = ECA.MODID, 
	name = ECA.NAME, 
	version = ECA.VERSION, 
	acceptedMinecraftVersions = "[1.12, 1.13)",
	dependencies = "required-after:jei@[4.12,)",
	clientSideOnly = true)
public class ECA
{
    public static final String MODID = "eca";
    public static final String NAME = "Ex Cinere Adscendere";
    public static final String VERSION = "1.0";

	public static Logger logger = LogManager.getLogger(MODID);
}