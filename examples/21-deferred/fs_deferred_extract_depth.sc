$input v_texcoord0

/*
 * Copyright 2011-2021 Branimir Karadzic. All rights reserved.
 * License: https://github.com/bkaradzic/bgfx#license-bsd-2-clause
 */

#include "common.sh"

SAMPLER2D(s_depth,  0);

void main()
{

	float deviceDepth = texture2D(s_depth, v_texcoord0).x;
	float depth       = toClipSpaceDepth(deviceDepth);

	gl_FragColor = vec4(deviceDepth, 1.0, 1.0, 1.0);

}
