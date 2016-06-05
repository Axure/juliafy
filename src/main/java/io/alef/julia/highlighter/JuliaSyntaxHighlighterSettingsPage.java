package io.alef.julia.highlighter;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import io.alef.julia.JuliaIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Created by zhenghu on 2016-06-05.
 */
public class JuliaSyntaxHighlighterSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Comma", JuliaSyntaxHighlighter.COMMA),
            new AttributesDescriptor("Semicolon", JuliaSyntaxHighlighter.SEMICOLON),
            new AttributesDescriptor("Comment", JuliaSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Number", JuliaSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("String", JuliaSyntaxHighlighter.STRING),
            new AttributesDescriptor("Id", JuliaSyntaxHighlighter.IDENTIFIER),
            new AttributesDescriptor("Operator", JuliaSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("Bracket", JuliaSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Keyword", JuliaSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Bad Character", JuliaSyntaxHighlighter.BAD_CHARACTER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return JuliaIcons.FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new JuliaSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "macro time(ex)\n" +
                "  return quote\n" +
                "    local t0 = time()\n" +
                "    local val = $ex\n" +
                "    local t1 = time()\n" +
                "    println(\"elapsed time: \", t1-t0, \" seconds\")\n" +
                "    val\n" +
                "  end\n" +
                "end";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Julia";
    }
}
