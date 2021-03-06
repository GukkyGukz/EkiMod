package chaos.mod.util.handlers;

import chaos.mod.util.network.PacketAnchorCreateStationWorker;
import chaos.mod.util.network.PacketVendorSpawnItemWorker;
import chaos.mod.util.network.PacketVendorWithdrawWorker;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	public static SimpleNetworkWrapper INSTANCE;

	public static int ID = 0;

	public static int nextID() {
		return ID++;
	}

	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);

		INSTANCE.registerMessage(PacketVendorSpawnItemWorker.Handler.class, PacketVendorSpawnItemWorker.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketVendorWithdrawWorker.Handler.class, PacketVendorWithdrawWorker.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketAnchorCreateStationWorker.Handler.class, PacketAnchorCreateStationWorker.class, nextID(), Side.SERVER);
	}
}
