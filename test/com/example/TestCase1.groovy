package com.example

import org.junit.Before
import org.junit.Test

import com.lesfurets.jenkins.unit.BasePipelineTest
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.LocalSource.localSource

class TestCase1 extends BasePipelineTest {

    @Override
    @Before
    void setUp() throws Exception {
        // TODO: Find a better way of getting project root dir
        String dirPath = new File( System.getProperty("user.dir") )
                .getAbsoluteFile()
                .getParentFile()
                .getAbsolutePath()

        def library = library()
                .name('jenkinslib-example')
                .allowOverride(true)
                .implicit(false)
                .targetPath(dirPath)
                .retriever(localSource(dirPath))
                .build()
        helper.registerSharedLibrary(library)

        super.setUp()
    }

    @Test
    void should_run_example_pipeline_without_errors() throws Exception {
        def script = loadScript("test\\resources\\pipelines\\example1.pipeline")
        script.execute()
        printCallStack()
    }
}
