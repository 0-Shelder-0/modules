package com.example.modules.extensions;

import com.drew.metadata.Tag;

public class TagExtensions {

    public static String getFormattedTagString(Tag tag) {
        return String.format("%s - %s\n", tag.getTagName(), tag.getDescription());
    }
}
