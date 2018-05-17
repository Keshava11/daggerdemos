package com.ravi.daggerdemos.di;


import com.ravi.daggerdemos.DaggerDemosActivity;
import com.ravi.daggerdemos.DaggerDemosFragment;
import com.ravi.daggerdemos.utils.ServiceUtils;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ServiceModule.class})
public interface ServiceComponent {

    // Define the class that will have the information from service module to be injected
    void inject(DaggerDemosActivity iMainActivity);
    void inject(ServiceUtils iServiceUtils);
    void inject(DaggerDemosFragment iMainFragment);
}
