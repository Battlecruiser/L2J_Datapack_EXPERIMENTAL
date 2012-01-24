/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package handlers.effecthandlers;

import com.l2jserver.gameserver.model.CharEffectList;
import com.l2jserver.gameserver.model.effects.EffectTemplate;
import com.l2jserver.gameserver.model.effects.L2Effect;
import com.l2jserver.gameserver.model.effects.L2EffectType;
import com.l2jserver.gameserver.model.stats.Env;

/**
 * @author -Rnn-
 * 
 */
public class PhysicalAttackMute extends L2Effect
{
	public PhysicalAttackMute(Env env, EffectTemplate template)
	{
		super(env, template);
	}
	
	/**
	 * 
	 * @see com.l2jserver.gameserver.model.effects.L2Effect#getEffectType()
	 */
	@Override
	public L2EffectType getEffectType()
	{
		return L2EffectType.PHYSICAL_ATTACK_MUTE;
	}
	
	/**
	 * 
	 * @see com.l2jserver.gameserver.model.effects.L2Effect#onStart()
	 */
	@Override
	public boolean onStart()
	{
		getEffected().startPhysicalAttackMuted();
		return true;
	}
	
	/**
	 * 
	 * @see com.l2jserver.gameserver.model.effects.L2Effect#onActionTime()
	 */
	@Override
	public boolean onActionTime()
	{
		// Simply stop the effect
		return false;
	}
	
	/**
	 * 
	 * @see com.l2jserver.gameserver.model.effects.L2Effect#onExit()
	 */
	@Override
	public void onExit()
	{
		getEffected().stopPhysicalAttackMuted(this);
	}

	/* (non-Javadoc)
	 * @see com.l2jserver.gameserver.model.L2Effect#getEffectFlags()
	 */
	@Override
	public int getEffectFlags()
	{
		return CharEffectList.EFFECT_FLAG_PSYCHICAL_ATTACK_MUTED;
	}
}