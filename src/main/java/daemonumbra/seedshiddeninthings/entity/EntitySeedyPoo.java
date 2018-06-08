package daemonumbra.seedshiddeninthings.entity;

import daemonumbra.seedshiddeninthings.SeedsHiddenInThings;
import daemonumbra.seedshiddeninthings.config.Config;
import daemonumbra.seedshiddeninthings.item.Items;
import daemonumbra.seedshiddeninthings.util.Constants;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;


public class EntitySeedyPoo extends EntityThrowable {

    public EntitySeedyPoo(World worldIn) {
        super(worldIn);
    }

    public EntitySeedyPoo(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntitySeedyPoo(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, ((double)this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(Items.SEEDY_POO));
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
        if (result.entityHit != null)
        {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if(!this.world.isRemote){
            int randomNum = (int)Math.round(Constants.RNG.nextDouble() * 100);
            if(randomNum <= Config.seedWeight){
                this.world.spawnEntity(new EntityItem(world,result.hitVec.x,result.hitVec.y,result.hitVec.z,new ItemStack(SeedsHiddenInThings.seedItems.get((int)(Constants.RNG.nextDouble() * (SeedsHiddenInThings.seedItems.size()))),1)));
            }
            this.world.setEntityState(this, (byte)3);
            this.setDead();
        }
    }

    /**
     * Shamelessly stolen from EntityPotion
     * @param p_190543_1_
     * @param p_190543_2_
     */
    private void applySplash(RayTraceResult p_190543_1_, List<PotionEffect> p_190543_2_)
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox().grow(4.0D, 2.0D, 4.0D);
        List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

        if (!list.isEmpty())
        {
            for (EntityLivingBase entitylivingbase : list)
            {
                if (entitylivingbase.canBeHitWithPotion())
                {
                    double d0 = this.getDistanceSq(entitylivingbase);

                    if (d0 < 16.0D)
                    {
                        double d1 = 1.0D - Math.sqrt(d0) / 4.0D;

                        if (entitylivingbase == p_190543_1_.entityHit)
                        {
                            d1 = 1.0D;
                        }

                        for (PotionEffect potioneffect : p_190543_2_)
                        {
                            Potion potion = potioneffect.getPotion();

                            if (potion.isInstant())
                            {
                                potion.affectEntity(this, this.getThrower(), entitylivingbase, potioneffect.getAmplifier(), d1);
                            }
                            else
                            {
                                int i = (int)(d1 * (double)potioneffect.getDuration() + 0.5D);

                                if (i > 20)
                                {
                                    entitylivingbase.addPotionEffect(new PotionEffect(potion, i, potioneffect.getAmplifier(), potioneffect.getIsAmbient(), potioneffect.doesShowParticles()));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
