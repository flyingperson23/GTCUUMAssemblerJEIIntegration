package com.flyingperson.eca;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class ECARecipeDisplayDataCache {
	private static final LoadingCache<ECAWrapper, ECARecipeDisplayData> cachedDisplayData = CacheBuilder.newBuilder()
			.maximumSize(25)
			.build(new CacheLoader<ECAWrapper, ECARecipeDisplayData>() {
				@Override
				public ECARecipeDisplayData load(ECAWrapper key) {
					return new ECARecipeDisplayData();
				}
			});

		public static ECARecipeDisplayData getDisplayData(ECAWrapper recipeWrapper) {
			return cachedDisplayData.getUnchecked(recipeWrapper);
		}
}
