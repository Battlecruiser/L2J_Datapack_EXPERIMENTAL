/*
 * Copyright (C) 2004-2013 L2J DataPack
 * 
 * This file is part of L2J DataPack.
 * 
 * L2J DataPack is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J DataPack is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package handlers.effecthandlers;

import com.l2jserver.gameserver.model.actor.L2Attackable;
import com.l2jserver.gameserver.model.actor.L2Character;
import com.l2jserver.gameserver.model.effects.EffectTemplate;
import com.l2jserver.gameserver.model.effects.L2Effect;
import com.l2jserver.gameserver.model.effects.L2EffectType;
import com.l2jserver.gameserver.model.stats.Env;
import com.l2jserver.gameserver.model.stats.Formulas;
import com.l2jserver.gameserver.util.Util;

/**
 * Transfer Hate effect implementation.
 * @author Adry_85
 */
public class TransferHate extends L2Effect
{
	private final int _chance;
	
	public TransferHate(Env env, EffectTemplate template)
	{
		super(env, template);
		_chance = template.hasParameters() ? template.getParameters().getInteger("chance", 100) : 100;
	}
	
	@Override
	public boolean calcSuccess()
	{
		return Formulas.calcProbability(_chance, getEffector(), getEffected(), getSkill());
	}
	
	@Override
	public L2EffectType getEffectType()
	{
		return L2EffectType.NONE;
	}
	
	@Override
	public boolean isInstant()
	{
		return true;
	}
	
	@Override
	public boolean onStart()
	{
		if (Util.checkIfInRange(getSkill().getEffectRange(), getEffector(), getEffected(), true))
		{
			for (L2Character obj : getEffector().getKnownList().getKnownCharactersInRadius(getSkill().getAffectRange()))
			{
				if ((obj == null) || !obj.isL2Attackable() || obj.isDead())
				{
					continue;
				}
				
				final L2Attackable hater = ((L2Attackable) obj);
				final int hate = hater.getHating(getEffector());
				if (hate <= 0)
				{
					continue;
				}
				
				hater.reduceHate(getEffector(), -hate);
				hater.addDamageHate(getEffected(), 0, hate);
			}
			return true;
		}
		return false;
	}
}
