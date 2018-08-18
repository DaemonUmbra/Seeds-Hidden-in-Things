package net.daemonumbra.seedshiddeninthings.entity;

import net.daemonumbra.seedshiddeninthings.config.SHiTConfig;
import net.daemonumbra.seedshiddeninthings.init.SHiTItems;
import net.daemonumbra.seedshiddeninthings.item.ItemSeedyPoo;
import net.daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * The main entity in SHiT, the real- ... I can't even make the joke without feeling disappointed in myself
 */
public class EntitySeedyPoo extends EntityPotion {
    private static List<PotionEffect> poison = new ArrayList<>();

    public EntitySeedyPoo(World worldIn) {
        super(worldIn);
        poison = ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation("minecraft","poison")).getEffects();
        poison.get(0).duration = 3*20;
    }

    public EntitySeedyPoo(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn, new ItemStack(SHiTItems.SEEDY_POO));
        poison = ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation("minecraft","poison")).getEffects();
        poison.get(0).duration = 3*20;
    }

    public EntitySeedyPoo(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z, new ItemStack(SHiTItems.SEEDY_POO));
        poison = ForgeRegistries.POTION_TYPES.getValue(new ResourceLocation("minecraft","poison")).getEffects();
        poison.get(0).duration = 3*20;
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(SHiTItems.SEEDY_POO));
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     *
     * @param result the given RayTraceResult
     */
    @Override
    protected void onImpact(@Nonnull RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
            }
            applySplash(result,poison);
            if(SHiTConfig.getSeedItems().isEmpty())
                return;
            int randomNum = (int) Math.round(rand.nextDouble() * 100);
            if (randomNum <= SHiTConfig.seedWeight) {
                this.world.spawnEntity(new EntityItem(world, result.hitVec.x, result.hitVec.y, result.hitVec.z, new ItemStack(SHiTConfig.getSeedItems().get((int) (rand.nextDouble() * (SHiTConfig.getSeedItems().size()))), 1)));
            }
            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }

    @SideOnly(Side.CLIENT)
    public static IRenderFactory getRenderFactory(){
        return manager -> new RenderSnowball(manager,SHiTItems.SEEDY_POO,Minecraft.getMinecraft().getRenderItem());
    }
}
