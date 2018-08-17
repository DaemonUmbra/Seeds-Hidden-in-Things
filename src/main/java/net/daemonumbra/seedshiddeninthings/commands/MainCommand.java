package net.daemonumbra.seedshiddeninthings.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManager;
import net.daemonumbra.seedshiddeninthings.capabilities.PooManagerProvider;
import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;
import net.daemonumbra.seedshiddeninthings.eventhandlers.EntityHandler;
import net.daemonumbra.seedshiddeninthings.util.MiscUtil;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * A command to reload the config on servers
 */
public class MainCommand implements ICommand {
    List<String> Aliases;
    List<String> Tab;

    public MainCommand() {
        Aliases = new ArrayList<>();
        Aliases.add("SeedsHiddenInThings");
        Aliases.add("seedshiddeninthings");
        Aliases.add("shit");

        Tab = new ArrayList<>();
        Tab.add("reload");
        Tab.add("poop");
        Tab.add("getttpc");
    }

    /**
     * Gets the name of the command
     */
    @Override
    public String getName() {
        return "seedshiddeninthings";
    }

    /**
     * Gets the usage string for the command.
     *
     * @param sender
     */
    @Override
    public String getUsage(ICommandSender sender) {
        return "/seedshiddeninthings <reload/poop>";
    }

    /**
     * Get a list of aliases for this command. <b>Never return null!</b>
     */
    @Override
    public List<String> getAliases() {
        return Aliases;
    }

    /**
     * Callback for when the command is executed
     *
     * @param server
     * @param sender
     * @param args
     */
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        switch (args[0].toLowerCase()){
            case "reload":{
                SHiTConfig.loadSeeds();
                break;
            }
            case "poop":{
                if(sender instanceof EntityPlayer){
                    MiscUtil.poop((EntityPlayer)sender);
                }else{
                    sender.sendMessage(new TextComponentString(ChatFormatting.RED + "ERROR: Only players can use this command"));
                }
                break;
            }
            case "getttpc":{
                if(sender instanceof Entity){
                    Entity entity = (Entity)sender;
                    if(entity.hasCapability(PooManagerProvider.POO_MANAGER,null)){
                        sender.sendMessage(new TextComponentString("Your TTPC is: " + entity.getCapability(PooManagerProvider.POO_MANAGER,null).getTicksToPoopChance()));
                    }else{
                        sender.sendMessage(new TextComponentString(ChatFormatting.RED + "Error: Entity does not have PooManager Capability"));
                    }
                }
                break;
            }
            default :{
                sender.sendMessage(new TextComponentString(ChatFormatting.RED + "Error: Unknown sub-command"));
            }
        }
    }

    /**
     * Check if the given ICommandSender has permission to execute this command
     *
     * @param server
     * @param sender
     */
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return sender.canUseCommand(4, this.getName());
    }

    /**
     * Get a list of options for when the user presses the TAB key
     *
     * @param server
     * @param sender
     * @param args
     * @param targetPos
     */
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Tab;
    }

    /**
     * Return whether the specified command parameter index is a username parameter.
     *
     * @param args
     * @param index
     */
    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(ICommand o) {
        return this.getName().compareTo(o.getName());
    }
}
