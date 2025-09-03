package app.demo.weds.network.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClientProvider {

    private const val SUPABASE_URL = "https://ujygjgglqgobfsgmlgdp.supabase.co"
    private const val SUPABASE_ANON_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InVqeWdqZ2dscWdvYmZzZ21sZ2RwIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTY4MjA2MTYsImV4cCI6MjA3MjM5NjYxNn0.DXKh4F-S_pBXT49woFHc0RFghYyyrxdguRHK-uHk8Z8"

    val client: SupabaseClient by lazy {
        createSupabaseClient(
            supabaseUrl = SUPABASE_URL,
            supabaseKey = SUPABASE_ANON_KEY
        ) {
            install(Auth) {
                alwaysAutoRefresh = true
                autoLoadFromStorage = true
            }
            install(Postgrest)
        }
    }
}
