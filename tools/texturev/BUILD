# bgfx.bazel - bgfx building in bazel
# Author: Alex Rozgo <alex.rozgo@gmail.com>

load("@rules_cc//cc:defs.bzl", "cc_binary")

cc_binary(
    name = "texturev",
    srcs = glob([
        "*.h",
        "texturev.cpp*",
    ]),
    linkopts = [
        "-lX11",
        "-lGL",
        "-lpthread",
        "-ldl",
    ],
    deps = [
        "//bgfx:common-linux",
    ],
)
