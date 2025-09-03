package app.demo.weds.di

import Repository
import app.demo.weds.natwork.repository.SignUpRepository

import app.demo.weds.natwork.viewmodel.AuthViewModel

import app.demo.weds.network.supabase.SupabaseClientProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Provide Supabase Client
    single { SupabaseClientProvider.client }

    // Provide Repositories
    single { Repository(context = get(), supabaseClient = get()) }
    single { SignUpRepository(supabaseClient = get()) }


    // Provide ViewModel
    viewModel { AuthViewModel(get(), get()) }
}
